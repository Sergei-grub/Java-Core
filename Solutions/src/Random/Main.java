package Random;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int num = 5;
        int[] array = new int[num];
        Random random = new Random();

        System.out.println("Генератор случайных чисел методом \"nextInt:\"");
        for (int n : array) {
            array[n] = random.nextInt(11);
            System.out.println(n);

        }
        System.out.println("Генератор случайных чисел методом \"Math.random()\":");
        for (int n : array) {
            array[n] = (int) (Math.random() * (50 - 1));
            System.out.println(n);

        }

        System.out.println("Генерация потока из диапазона случайных целочисленных значений методом \"ints()\":");
        random.ints(5, 1, 10).sorted().forEach(System.out::println);


        System.out.println("Генерация уникальных случайных чисел методом \"nextInt()\":");
        for (int i = 0; i < array.length; i++) {
            array[i]  = random.nextInt(10 - 1) + 1;
            System.out.println(array[i]);
        }

        System.out.println("Отсортированный массив: ");
        Arrays.sort(array);
        for (int n : array) {
            System.out.println(n);
        }
    }
}