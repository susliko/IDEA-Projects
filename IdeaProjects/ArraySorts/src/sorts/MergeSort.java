package sorts;

public class MergeSort {

    private static int[] helper;

    //Public function for external use
    public static void sort(int[] arr) {
        helper = new int[arr.length]; // Сразу выделяем память для вспомогательного массива
        sort(arr,0, arr.length-1);
    }

    //
    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left)/2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    //Function to merge sorted parts of an array
    private static void merge(int[] arr, int left, int mid, int right) {
        System.arraycopy(arr, 0, helper, 0, arr.length);

        int i = left, j = mid+1;

        for (int k = left; k <= right; k++) {
            if (i > mid) arr[k] = helper[j++];
            else if (j > right) arr[k] = helper[i++];
            else if (helper[i] < helper[j]) arr[k] = helper[i++];
            else arr[k] = helper[j++];
        }
    }

}
