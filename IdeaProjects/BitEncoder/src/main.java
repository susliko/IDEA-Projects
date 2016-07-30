import java.util.Arrays;

public class main {


    public static void main(String[] args) {
        String input = "attack at dawn";
        String result = "6c73d5240a948c86981bc294814d";

        char[] a = input.toCharArray();
        int[] a1 = new int[a.length];
        for (int i = 0; i < a.length; i++){
            a1[i] = a[i];
        }


        int[] c = new int[result.length()/2];
        for (int i = 0; i < result.length()/2; i++)
        {
            c[i] = Integer.parseInt(result.subSequence(2*i,2*i+2).toString(),16);
        }


        int[] b = new int[a1.length];
        for (int i = 0; i < a1.length; i++) {
            b[i] = a1[i] ^ c[i];
        }

        System.out.println(Arrays.toString(a1));
        System.out.println("   xor");
        System.out.println(Arrays.toString(b));
        System.out.println("   =");
        System.out.println(Arrays.toString(c));

        String toCode = "attack at dusk";
        char[] r = toCode.toCharArray();
        int[] r1 = new int[r.length];
        for (int i = 0; i < r.length; i++){
            r1[i] = r[i];
        }




        int[] resHex = new int[r1.length];
        for (int i = 0; i < r1.length; i++) {
            resHex[i] = r1[i] ^ b[i];
        }
        System.out.println("resHex : \n"+Arrays.toString(resHex));
        for (int i = 0; i < resHex.length; i++) {
            System.out.print(Integer.toHexString(resHex[i])+" ");
        }
}}

