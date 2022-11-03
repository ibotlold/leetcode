import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(0, n);
        }
        System.out.println(Arrays.toString(array));
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class QuickSort {
    static int[] sort(int[] array) {
//        hoare(array, 0, array.length - 1);
        return array;
    }



    private static void hoare(int[] array, int start, int end) {
        if (start >= 0 && end >= 0 && start < end) {
            int partitionIndex = partition(array, start, end);
            hoare(array, start, partitionIndex);
            hoare(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {

        int pivotIndex = (int)(Math.random() * (end - start) + start);
        int i = start - 1;
        int j = end + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < array[pivotIndex]);
            do {
                j--;
            } while (array[j] > array[pivotIndex]);

            if (i >= j) return j;
            int cache = array[i];
            array[i] = array[j];
            array[j] = cache;
        }
    }
}