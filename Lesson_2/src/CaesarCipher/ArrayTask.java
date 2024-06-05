package CaesarCipher;


import java.util.Arrays;

public class ArrayTask {
    // Задать одномерный массив. Написать методы поиска в нём минимального и
    // максимального элемента;

    static int findMin(int[] a) { // returns the minimum value
        System.out.print("returns the minimum value: ");
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    // Поиск индекса максимального значения
    static int findMax(int[] a) { // returns the maximum index
        System.out.print("returns the maximum index: ");
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[max])
                max = i;
        }
        return max;
    }


    // Создать квадратный целочисленный массив (количество строк и столбцов оди-
    // наковое), заполнить его диагональные элементы единицами, используя цикл(ы)
    static void fillDiagonal(int[][] arr) {
//        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

    }

//    Написать метод, в который передается не пустой одномерный целочисленный
//    массив, метод должен вернуть true если в массиве есть место, в котором сумма
//    левой и правой части массива равны. Примеры:
//    checkBalance([1, 1, 1, || 2, 1])→true,
//    checkBalance([2, 1, 1, 2, 1])→false,
//    checkBalance([10, || 1, 2, 3, 4])→true.
//    Абстрактная граница показана символами ||, эти символы в массив не входят.


    static boolean checkBalance1(int[] a) { // Вариант со сложностью O(n2)
        System.out.println("Вариант со сложностью O(n2)");
        int left = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < a.length - 1; i++) {
            left += a[i];
            int right = 0;
            for (int j = i + 1; j < a.length; j++) {
                right += a[j];
            }
            if (left == right){

                return true;
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
        return false;
    }


    static boolean checkBalance2(int[] a) { // Листинг 9: Вариант со сложностью O(2n)
        System.out.println("Вариант со сложностью O(2n)");
        int sum = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

        }
        if (sum % 2 != 0) {

            return false;
        }
        int left = 0;
        for (int i = 0; i < a.length; i++) {
            left += a[i];
            sum -= a[i];
            if (left == sum) {

                return true;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
        return false;
    }


//∗1 написать этот же метод таким образом, чтобы в нём использовался только один цикл.

    static boolean checkBalance3(int[] a) {//Листинг 10: * Вариант со сложностью O(n)
        System.out.println("* Вариант со сложностью O(n)");
        long startTime = System.currentTimeMillis();

        int lbound = 0;
        int rbound = a.length - 1;
        int left = 0;
        int right = 0;

        while (lbound <= rbound) {
            if (left > right) {
                right += a[rbound--];

            } else {
                left += a[lbound++];

            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
        return left == right;
    }
}
