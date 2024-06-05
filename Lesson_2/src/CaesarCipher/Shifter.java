package CaesarCipher;

import java.util.Arrays;

public class Shifter {

    //    Написать метод, принимающий на вход массив чисел и параметр n. Метод
//    должен осуществить циклический (последний элемент при сдвиге становится
//    первым) сдвиг всех элементов массива на n позиций;
    private static void shifter(int[] a, int n) {
        n %= a.length;
        System.out.println(n %= a.length);
        int shift = a.length + n;
        shift %= a.length;
        System.out.println(Arrays.toString(a));


        for (int i = 0; i < shift; i++) {
            int temp = a[a.length - 1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 8, 6};
        int n = 4;

        shifter(arr, n);
    }
}
