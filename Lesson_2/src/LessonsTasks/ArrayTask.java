package LessonsTasks;


import java.util.Arrays;

public class ArrayTask {
    // Задать одномерный массив. Написать методы поиска в нём минимального и
    // максимального элемента;

    static int findMin(int[] a) { // returns the minimum value
//        System.out.print("returns the minimum value: ");
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    static int findMax(int[] a) { // returns the minimum value
//        System.out.print("returns the minimum value: ");
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    // Поиск индекса максимального значения
    static int findMaxIndex(int[] a) { // returns the maximum index
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
            if (left == right) {

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

        int lBound = 0;
        int rBound = a.length - 1;
        int left = 0;
        int right = 0;

        while (lBound <= rBound) {
            if (left > right) {
                right += a[rBound--];
            } else {
                left += a[lBound++];
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");

        return left == right;
    }

// Написать функцию добавления элемента в конец массива таким образом, чтобы
// она расширяла массив при необходимости.
// Здесь нет смысла показывать не лучшее, но самое популярное решение, поэтому
// можно продемонстрировать сразу вариант решения «со звёздочкой».
// ∗1 Функция должна возвращать ссылку на вновь созданный внутри себя массив, а
// не использовать глобальный

    static int[] addToArray(int[] arr, int current, int value) {
        System.out.println("Функция добавляет элемента в конец массива");
        if (current == arr.length) {
            int[] temp = new int[arr.length + 1];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[current] = value;
        return arr;
    }

    // Написать метод, возвращающий количество чётных элементов массива
    static void countEvens(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println("Количество чётных элементов массива" + counter);
    }
}




