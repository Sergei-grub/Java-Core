package JavaCoreFinalTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    // Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup.
    // Решить задачи из презентации к семинару.

    private static final Random random = new Random();

    private static final int CHAR_BOUND_L = 65; // Номер начального символа
    private static final int CHAR_BOUND_H = 90; // Номер конечного символа
    private static final String TO_SEARCH = "GeekBrains"; // для поиска

    public static void main(String[] args) throws IOException {
        //String str = generateSymbols(15);
        //System.out.println(str);
        writeFileContents("sample01.txt", 30, 5);
        System.out.println(searchInFile("sample01.txt", TO_SEARCH));

        writeFileContents("sample02.txt", 30, 5);
        System.out.println(searchInFile("sample02.txt", TO_SEARCH));
        concatenate("sample01.txt", "sample02.txt", "sample01_out.txt");
        System.out.println(searchInFile("sample01_out.txt", TO_SEARCH));

        Tree.print(new File("."), "", true);

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "file_" + i + ".txt";
            writeFileContents(fileNames[i], 100, 4);
            System.out.printf("Файл %s создан.\n", fileNames[i]);
        }

        List<String> result = searchMatch(fileNames, TO_SEARCH);
        for (String s : result) {
            System.out.printf("Файл %s содержит искомое слово '%s'\n", s, TO_SEARCH);
        }
        new Backup(".").copy();

    }

    // Метод генерации символов

    private static String generateSymbols(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++)
            stringBuilder.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        return stringBuilder.toString();
    }

    // Записать последовательность символов в файл

//    private static void writeFileContents(String fileName, int length) throws IOException {
//        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
//            fileOutputStream.write(generateSymbols(length).getBytes());
//        }
//    }

    // Запись последовательность символов в файл и случайным образом дописать слово для поиска
     private static void writeFileContents(String fileName, int length, int words) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < words; i++) {
                if (random.nextInt(5) == 5 / 2) {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                } else {
                    fileOutputStream.write(generateSymbols(length).getBytes());
                }
            }
            fileOutputStream.write(' ');
        }
    }

    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {
            int c;
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)) {
                while ((c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
            try (FileInputStream fileInputStream = new FileInputStream(fileIn2)) {
                while ((c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }

// Определить, содержится ли в файле искомое слово

    private static boolean searchInFile(String fileName, String search) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int c;
            int i = 0;
            while ((c = fileInputStream.read()) != -1) {
                if (c == searchData[i]) {
                    i++;
                } else {
                    i = 0;
                    if (c == searchData[i]) // GeekBrainGeekBrains
                        i++;
                    continue;
                }
                if (i == searchData.length) {
                    return true;
                }
            }
            return false;
        }
    }

    private static List<String> searchMatch(String[] files, String search) throws IOException {
        List<String> list = new ArrayList<>();
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory())
                continue;
            for (int j = 0; j < files.length; j++) {
                if (dir[i].getName().equals(files[j])) {
                    if (searchInFile(dir[i].getName(), search)) {
                        list.add(dir[i].getName());
                        break;
                    }
                }
            }
        }
        return list;
    }
}