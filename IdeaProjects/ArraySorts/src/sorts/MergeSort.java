package sorts;

public class MergeSort {

    private static int[] hlpr;

    public static void sort(int[] arr) {
        hlpr = new int[arr.length];
        sort(arr,0, arr.length-1);
    }

    private static void sort(int[] arr, int li, int ri) {
        if (li >= ri) return;

        int mid = li + (ri - li)/2;
        sort(arr, li, mid);
        sort(arr, mid + 1, ri);

        merge(arr, li, mid, ri);
    }

    private static void merge(int[] arr, int li, int mid, int ri) {
        System.arraycopy(arr, 0, hlpr, 0, arr.length);

        int i = li, j = mid+1;

        for (int k = li; k <= ri; k++) {
            if (i > mid) arr[k] = hlpr[j++];
            else if (j > ri) arr[k] = hlpr[i++];
            else if (hlpr[i] < hlpr[j]) arr[k] = hlpr[i++];
            else arr[k] = hlpr[j++];
        }
    }

}
