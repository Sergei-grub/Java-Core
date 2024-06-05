package CaesarCipher;


public class CaesarCipher {

//   Написать метод «Шифр Цезаря», с булевым параметром
//   зашифрования/расшифрования, и числовым ключом;

    private static String caesar(String in, int key, boolean encrypt) {
        if (in == null || in.isEmpty())
            return null;

        final int len = in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; ++i) {
            out[i] = (char) (in.charAt(i) + ((encrypt) ? key : -key));
        }
        return new String(out);
    }




    public static void main(String[] args) {
        String in = "Caesar";
        int key = 1228;
        boolean encrypt = false;

        System.out.println(caesar(in, key, encrypt));

    }
}
