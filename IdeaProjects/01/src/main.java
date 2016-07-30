import java.util.Arrays;

public class main {

    static int[] m = new int[7];

    static int res = 0;
    static int sum = 0;

    static void Forer(int values, int[] m, int index, boolean callNext) {



        for (int i = 0; i <= values; i++) {

            if (index < m.length - 1) callNext = true;

            m[index] = i;


            if (checkArray(2016))

             {
                res++;
                System.out.println( Arrays.toString(m) + " sum : " + sum);
            }

            if (callNext) {
                if (index == 5) callNext = false;
                Forer(values, m, index + 1, callNext);
            }


        }
    }

    static boolean checkArray(int input) {
        sum = 0;

        for (int i = 0; i < m.length; i++)
            sum += m[i] * Math.pow(3, i);
        if (input == sum)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        Forer(3, m, 0, true);
        System.out.println(res);
    }
}
