public class Timer {

    public static long measureTimeMillis (Sorter sorter, int[] arr) {
        long startTime = System.currentTimeMillis();
        sorter.sort(arr);
        return System.currentTimeMillis() - startTime;
    }

    public static long measureTimeNanos (Sorter sorter, int[] arr) {
        long startTime = System.nanoTime();
        sorter.sort(arr);
        return System.nanoTime() - startTime;
    }
}
