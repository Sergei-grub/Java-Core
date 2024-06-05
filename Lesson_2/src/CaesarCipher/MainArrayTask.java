package CaesarCipher;

public class MainArrayTask {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 7, 9, 14, 10};

        System.out.println(ArrayTask.findMin(arr));

        System.out.println(ArrayTask.findMax(arr));

        int[][] array = new int[5][5];
        ArrayTask.fillDiagonal(array);


        int[] Balance1 = new int[] {1, 1, 1, 2, 1};
        int[] Balance2 = new int[] {2, 1, 1, 2, 1};
        int[] Balance3 = new int[] {10, 1, 2, 3, 4};


        System.out.println(ArrayTask.checkBalance1(Balance1));
        System.out.println(ArrayTask.checkBalance1(Balance2));
        System.out.println(ArrayTask.checkBalance1(Balance3));

        System.out.println(ArrayTask.checkBalance2(Balance1));
        System.out.println(ArrayTask.checkBalance2(Balance2));
        System.out.println(ArrayTask.checkBalance2(Balance3));

        System.out.println(ArrayTask.checkBalance3(Balance1));
        System.out.println(ArrayTask.checkBalance3(Balance2));
        System.out.println(ArrayTask.checkBalance3(Balance3));

    }
}
