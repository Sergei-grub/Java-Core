package ByteArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringBufferInputStream;

public class ByteArrayStream {
    public static void main(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(1);
        out.write(-1);
        out.write(0);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        int value = in.read();
        System.out.println("First element is - " + value);
        value = in.read();
        System.out.println("Second element is - " + value + ". If (byte)value - " + (byte)value);
        value = in.read();
        System.out.println("Third element is - " + value);


        byte[] bytes = {1,-1,0};
        ByteArrayInputStream inn = new ByteArrayInputStream(bytes);
        int readedInt = inn.read(); // readedInt=1
        int readedInt2 = inn.read();
        int readedInt3 = inn.read();
        int readedInt4 = inn.read();
        int readedInt5 = inn.read();
        System.out.println("first element read is: " + readedInt);
        System.out.println("first element read is: " + readedInt2);
        System.out.println("first element read is: " + readedInt3);
        System.out.println("first element read is: " + readedInt4);
        System.out.println("first element read is: " + readedInt5);

        ByteArrayOutputStream outt = new ByteArrayOutputStream();
        out.write(10); outt.write(11);
        byte[] bytes2 = outt.toByteArray();
    }
}
