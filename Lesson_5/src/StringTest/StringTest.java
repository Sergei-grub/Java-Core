package StringTest;

import java.nio.charset.StandardCharsets;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = new String("Home");
        String s3 = new String(new char[]{'A', 'B', 'C'});
        String s4 = new String(s3);
        String s5 = new String(new byte[]{65, 66, 67});
        String s6 = new String(new byte[]{0, 65, 0, 66}, StandardCharsets.UTF_16);
        String s7 = "Fifty five is " + 50 + 5; // Fifty five is 505
        String s8 = 50 + 5 + " = Fifty five"; // 55 = Fifty five
        System.out.println(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n"
                + "Fifty five is + 50 + 5 > " + s7 + "\n" + "0 + 5 + Fifty five is > " + s8 + "\n" );
    }
}
