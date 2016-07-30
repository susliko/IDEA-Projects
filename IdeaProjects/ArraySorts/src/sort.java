import sorts.BubbleSort;
import sorts.HeapSort;
import sorts.MergeSort;
import sorts.QuickSort;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class sort {

    public static int[] arrayGeneration(int length, int bound) {

        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(bound);
        }

        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void showTestResult(String SortName, long nanos) {
        System.out.println(SortName + " : " + nanos + " nanoseconds");
    }

    public static void main(String[] args) {

        int[] arr1 = arrayGeneration(100,100);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        int[] arr4 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("Random array size : " + arr1.length + "\n");

//        printArray(arr4);
        Map.Entry

        showTestResult("BubbleSort", Timer.measureTimeNanos(BubbleSort::sort, arr1));

        showTestResult("MergeSort ", Timer.measureTimeNanos(MergeSort::sort, arr2));

        showTestResult("QuickSort ", Timer.measureTimeNanos(QuickSort::sort, arr3));

        showTestResult("HeapSort  ", Timer.measureTimeNanos(HeapSort::sort, arr4));

    }
}
