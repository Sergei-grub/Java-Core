package CaesarCipher;

import java.util.Arrays;

public class Change {

    //    Написать метод, которому можно передать в качестве аргумента массив,
//    состоящий строго из единиц и нулей (целые числа типа int). Метод должен заменить
//    единицы в массиве на нули, а нули на единицы и не содержать ветвлений.
//    Написать как можно больше вариантов метода
    private static void change(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 - a[i];
//            a[i] = (a[i] - 1) * -1;
//            a[i] = (a[i] + 1) % 2;

        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] arr2 = new int[]{1, 0, 0, 0, 0, 1};
        change(arr2);
    }
}
