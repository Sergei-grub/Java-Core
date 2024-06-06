package LessonsTasks;

import java.util.Arrays;

public class SortTasks {

    static void pigeonholeSort(int[] arrayPig) {
        System.out.println("До сортировки: " + Arrays.toString(arrayPig));
        final int min = ArrayTask.findMin(arrayPig);
        final int max = ArrayTask.findMax(arrayPig);
        System.out.println("min: " + min + "\nmax: " + max);
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < arrayPig.length; i++)
            freq[arrayPig[i] - min]++;

        int arrIndex = 0;
        for (int i = 0; i < freq.length; i++)
            for (int elems = freq[i]; elems > 0; elems--)
                arrayPig[arrIndex++] = i + min;
        System.out.println("После сортировки: " + Arrays.toString(arrayPig));
    }


}
