import java.util.Arrays;

public class main {

    static int[][] table = new int[11][11];
    static int partition(int sum, int largestNumber){
        if (largestNumber==0)
            return 0;
        if (sum==0)
            return 1;
        if (sum<0)
            return 0;

        if (table[sum][largestNumber]!=0)
            return table[sum][largestNumber];

        table[sum][largestNumber]=partition(sum,largestNumber-1)
                + partition(sum-largestNumber,largestNumber);
        return table[sum][largestNumber];

    }

    public static void main(String[] args) {
        System.out.println(partition(10, 9));
        for (int i = 0; i < table.length; i++)
        System.out.println(i + " " + Arrays.toString(table[i]));
    }
}
