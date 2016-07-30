package sorts;

public class QuickSort{

    public static void sort(int[] arr) {
        qsort(arr ,0 ,arr.length - 1);
    }

    private static void qsort(int[] arr, int b, int e) {
        int l = b, r = e;

        int pivot = arr[(b+e)/2];

        while (l <= r) {
            while (arr[l] < pivot)
                l++;
            while (arr[r] > pivot)
                r--;
            if (l <= r) swap(arr, l++, r--);
        }

        if (b < r)
            qsort(arr, b, r);
        if (e > l)
            qsort(arr, l, e);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
