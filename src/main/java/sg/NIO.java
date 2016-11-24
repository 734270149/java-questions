package sg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by shiguang3 on 2016/5/5.
 */
public class NIO {
    public static void main(String[] args) {
        try {
            File file = new File("NIO.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);
            while (read != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
                read = channel.read(buffer);
            }
            buffer.put((byte) 'a');
            buffer.flip();
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            channel.force(true);
            channel.close();
            accessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
