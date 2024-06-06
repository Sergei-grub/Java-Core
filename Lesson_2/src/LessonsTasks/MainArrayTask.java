package LessonsTasks;

import java.util.Arrays;

public class MainArrayTask {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 7, 9, 14, 10};

        System.out.println(ArrayTask.findMin(arr));

        System.out.println(ArrayTask.findMaxIndex(arr));

        int[][] array = new int[5][5];
        ArrayTask.fillDiagonal(array);


        int[] Balance1 = new int[]{1, 1, 1, 2, 1};
        int[] Balance2 = new int[]{2, 1, 1, 2, 1};
        int[] Balance3 = new int[]{10, 1, 2, 3, 4};


        System.out.println(ArrayTask.checkBalance1(Balance1));
        System.out.println(ArrayTask.checkBalance1(Balance2));
        System.out.println(ArrayTask.checkBalance1(Balance3));

        System.out.println(ArrayTask.checkBalance2(Balance1));
        System.out.println(ArrayTask.checkBalance2(Balance2));
        System.out.println(ArrayTask.checkBalance2(Balance3));

        System.out.println(ArrayTask.checkBalance3(Balance1));
        System.out.println(ArrayTask.checkBalance3(Balance2));
        System.out.println(ArrayTask.checkBalance3(Balance3));


        int[] arrayAdd = {1, 2};
        int size = 2;
        arrayAdd = ArrayTask.addToArray(arrayAdd, size++, 6);
        System.out.println(size + " = " + Arrays.toString(arrayAdd) + "\n");

        arrayAdd = ArrayTask.addToArray(arrayAdd, size++, 5);
        System.out.println(size + " = " + Arrays.toString(arrayAdd) + "\n");

        arrayAdd = ArrayTask.addToArray(arrayAdd, size++, 8);
        System.out.println(size + " = " + Arrays.toString(arrayAdd) + "\n");

    //Метод, возвращающий количество чётных элементов массива.
    //countEvens4([2, 1, 2, 3, 4])→3
    //countEvens5([2, 2, 0])→3
    //countEvens6([1, 3, 5])→0
        int[] countEvens4 = new int[]{2, 1, 2, 3, 4};
        int[] countEvens5 = new int[]{2, 2, 0};
        int[] countEvens6 = new int[]{1, 3, 5};
        ArrayTask.countEvens(countEvens4);
        ArrayTask.countEvens(countEvens5);
        ArrayTask.countEvens(countEvens6);
    }

}
