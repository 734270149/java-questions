package compress;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Enumeration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Zip {

  @Test
  public void add_all_files_from_a_directory_to_a_zip_archive() throws Exception {
    File source = new File("build/resources/test");
    File destination = new File("build/resources.zip");
    destination.delete();

    addFilesToZip(source, destination);

    assertTrue("Expected to find the zip file ", destination.exists());
    assertZipContent(destination);
  }

  /**
   * Add all files from the source directory to the destination zip file
   *
   * @param source      the directory with files to add
   * @param destination the zip file that should contain the files
   * @throws IOException      if the io fails
   * @throws ArchiveException if creating or adding to the archive fails
   */
  private void addFilesToZip(File source, File destination) throws IOException, ArchiveException {
    OutputStream archiveStream = new FileOutputStream(destination);
    ArchiveOutputStream
        archive =
        new ArchiveStreamFactory()
            .createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);

    Collection<File> fileList = FileUtils.listFiles(source, null, true);

    for (File file : fileList) {
      String entryName = getEntryName(source, file);
      ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
      archive.putArchiveEntry(entry);

      BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));

      IOUtils.copy(input, archive);
      input.close();
      archive.closeArchiveEntry();
    }

    archive.finish();
    archiveStream.close();
  }

  /**
   * Remove the leading part of each entry that contains the source directory name
   *
   * @param source the directory where the file entry is found
   * @param file   the file that is about to be added
   * @return the name of an archive entry
   * @throws IOException if the io fails
   */
  private String getEntryName(File source, File file) throws IOException {
    int index = source.getAbsolutePath().length() + 1;
    String path = file.getCanonicalPath();

    return path.substring(index);
  }

  private void assertZipContent(File destination) throws IOException {
    ZipFile zipFile = new ZipFile(destination);

    ZipArchiveEntry readme = zipFile.getEntry("readme.txt");
    assertNotNull(readme);

    Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
    int numberOfEntries = 0;
    while (entries.hasMoreElements()) {
      numberOfEntries++;
      entries.nextElement();
    }
    assertThat(numberOfEntries, is(1));
  }
}
