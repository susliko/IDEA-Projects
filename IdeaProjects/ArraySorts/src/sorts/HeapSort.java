package sorts;

public class HeapSort {

    public static void sort(int[] arr) {
        maxHeapCreate(arr, arr.length);
        for (int i = arr.length - 1; i >= 2; i--) {
            swap(arr, 0, i);
            maxHeapify(arr,0,i-1);
        }
    }

    private static void maxHeapCreate(int[] arr, int heap_size) {
        for (int i = heap_size/2-1; i >= 0; i--) {
            maxHeapify(arr, i, heap_size);
        }
    }

    private static void maxHeapify(int[] arr, int i, int heap_size) {
        int l = leftChild(i), r = rightChild(i), largest;
        if ((l < heap_size) && arr[l] > arr[i]) largest = l;
            else largest = i;
        if ((r < heap_size) && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            swap(arr,i,largest);
            maxHeapify(arr, largest, heap_size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int leftChild(int i) {
        return (2*i);
    }

    private static int rightChild(int i) {
        return (2*i+1);
    }
}
