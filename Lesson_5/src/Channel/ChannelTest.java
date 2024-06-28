package Channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Листинг 15: Использование буфера и канала
 * @author SG
 * @version  1.0
 * @since 2014-03-31
 */
public class ChannelTest {
    public static void main(String[] args) {


        try (RandomAccessFile catFile = new RandomAccessFile("cat.txt", "rw")) {
            FileChannel inChannel = catFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(100);
            int bytesRead = inChannel.read(buf);
            int count = 0;
            while (bytesRead != -1) {
                count++;
                System.out.println("Read " + bytesRead + " bytes"); // Set read mode
                buf.flip();
//                while (buf.hasRemaining()) {
//                    System.out.print((char) buf.get());
//                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            System.out.println(count * 0.0001 + " мб");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
