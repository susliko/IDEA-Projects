import java.util.Arrays;

public class main {

    static void checkArray(int... arr) {
        int[] m = new int[arr.length];
        m[0] = arr [0];



        for (int a = 1; a < 1000; a++) {
            for (int p = a+1; p < 1001; p++) {
                for (int i = 1; i < arr.length; i++) {
                m[i] = (int) ((Math.pow(a, m[i-1])) % p);
                }
                if (Arrays.equals(m,arr)) {
                    System.out.println("a : " + a + " p : " + p);
                    int first = newNum(a,p,m[m.length-1]);
                    int second = newNum(a,p,first);
                    int third = newNum(a,p,second);
                    int fourth = newNum(a,p,third);
                    System.out.println(first+" "+second+" "+third+" "+fourth);
                }
            }
        }
    }

    static int newNum(int a, int p,int m) {
        return (int) ((Math.pow(a,m))%p);
    }

    public static void main(String[] args) {
                checkArray(1,4,96,55);
    }
}
