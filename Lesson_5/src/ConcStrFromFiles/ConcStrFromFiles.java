package ConcStrFromFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ConcStrFromFiles {

    private static final Random rnd = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final int FILES_AMOUNT = 10;
    private static final int WORDS_AMOUNT = 5;
    private static final int WORD_LENGTH = 10;
    private static final String WORD_TO_SEARCH = "geekbrains";


    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++)
            sequence.append((char) (CHAR_BOUND_L + rnd.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
        return sequence.toString();
    }

    private static void writeFileContents(String fileName, int words, int length) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        for (int i = 0; i < words; i++) {
            if (rnd.nextInt(WORDS_AMOUNT) == WORDS_AMOUNT / 2)
                fos.write(WORD_TO_SEARCH.getBytes());
            else
                fos.write(generateSymbols(length).getBytes());
            fos.write(' ');
        }
        fos.flush();
        fos.close();
    }

    private static void concatenate(String file_in1, String file_in2, String file_out) throws IOException {
        FileOutputStream fos = new FileOutputStream(file_out);
        int ch;
        FileInputStream fis = new FileInputStream(file_in1);
        while ((ch = fis.read()) != -1)
            fos.write(ch);
        fis.close();

        fis = new FileInputStream(file_in2);
        while ((ch = fis.read()) != -1)
            fos.write(ch);
        fis.close();

        fos.flush();
        fos.close();
    }

    private static boolean isInFile(String fileName, String search) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = fis.read()) != -1 && sb.length() < search.length()) {
                sb.append((char) ch);
            }

            do {
                if (sb.toString().equals(search))
                    return true;
                sb.deleteCharAt(0);
                sb.append((char) ch);
            } while ((ch = fis.read()) != -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = new String[FILES_AMOUNT];
        for (int i = 0; i < fileNames.length; i++)
            fileNames[i] = "file_" + i + ".txt";

//        try {
//            //#1
//            for (int i = 0; i < fileNames.length; i++)
//                if (i < 2)
//                    writeFileContents(fileNames[i], 10, 5);
//                else
//                    writeFileContents(fileNames[i], WORDS_AMOUNT, WORD_LENGTH);
//            System.out.println("First task results are in file_0 and file_1.");
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//        concatenate("file_0.txt", "file_1.txt", "file_out.txt");
        System.out.println(isInFile("file_6.txt", "geekbrains"));
    }
}