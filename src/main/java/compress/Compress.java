package compress;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;

import com.alibaba.fastjson.JSON;

import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shiguang3 on 2016/8/23.
 */
public class Compress {

  public static void main(String[] args) throws IOException {
//        csv();
//        immutableList();
//        compress();
//        SG a = a(new In());
//        System.out.println(JobType.getJobName((byte) 1));
//        System.out.println(JobType.getJobName((byte) 11));
//        System.out.println(DataStatus.getStatusName(5));
//        System.out.println(DataStatus.getStatusName(22));
    String s = JSON.toJSONString(new Date());
    Object o = JSON.parseObject(s, Object.class);
    System.out.println(o);
  }

  private static <T> T a(Inter<T> i) {
    return i.get();
  }

  private static void compress() throws IOException {
    File file2 = new File("temp.zip");
    File sourceDir = new File("file");
    System.out
        .println(sourceDir.getCanonicalPath() + sourceDir.getAbsolutePath() + sourceDir.getPath());
    ZipArchiveOutputStream stream = new ZipArchiveOutputStream(file2);
    //默认就是这个
    stream.setUseZip64(Zip64Mode.AsNeeded);
    File[] files = sourceDir.listFiles();
    if (files == null) {
      return;
    }
    for (File file : files) {
      System.out.println(file.getName());
      stream.putArchiveEntry(stream.createArchiveEntry(file, file.getName()));
      InputStream is = null;
      try {
        is = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024 * 4];
        int len;
        while ((len = is.read(buffer)) != -1) {
          //把缓冲区的字节写入到ZipArchiveEntry
          stream.write(buffer, 0, len);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        if (is != null) {
          is.close();
        }
      }
      stream.closeArchiveEntry();
    }
    stream.finish();
    stream.close();
  }

  private static void immutableList() {
    ArrayList<SG> objects = new ArrayList<SG>();
    objects.add(new SG() {{
      setS("aa");
    }});
    ImmutableList<SG> immutableList = ImmutableList.<SG>builder().addAll(objects).add(new SG() {{
      setS("aa");
    }}).build();
    ImmutableList<SG> sgs = ImmutableList.copyOf(immutableList);
    System.out.println(objects);
    System.out.println(immutableList);
    objects.get(0).setS("bb");
    System.out.println(objects);
    System.out.println(immutableList);
    System.out.println(sgs);
  }

  private static void csv() throws IOException {
    //withQuote(null)防止源码里的双引号放换格的封装
    //玄机在CSVFormat的992,1002,1038行
    CSVFormat format = CSVFormat.DEFAULT.withQuote(null);
    File file = new File("file/temp.csv");
    if (!file.exists()) {
      file.createNewFile();
    }
    BufferedWriter bufferedWriter = Files.newWriter(file, Charsets.UTF_8);
    CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, format);
    ArrayList<SG> arrayList = new ArrayList<SG>();
    arrayList.add(new SG("a"));
    arrayList.add(new SG("b"));
    arrayList.add(new SG("c"));
    csvPrinter.printRecords(arrayList);
    csvPrinter.flush();
    csvPrinter.close();
    System.out.println(new SG("a").toString());
  }

  private interface Inter<T> {

    T get();
  }

  private static final class In implements Inter<SG> {

    public SG get() {
      return null;
    }
  }
}
