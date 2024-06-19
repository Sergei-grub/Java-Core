package ByteArrayStream;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {
        String fileName = "test.txt";
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            long timeStart = System.currentTimeMillis();
            outStream = new BufferedOutputStream(new
                    FileOutputStream(fileName));
            for (int i = 1000000; --i >= 0;) {
                outStream.write(i);
            }
            long time = System.currentTimeMillis() - timeStart;
            System.out.println("Writing time: " + time + " millisec");
            outStream.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
            e.printStackTrace();
        }
    }
}
