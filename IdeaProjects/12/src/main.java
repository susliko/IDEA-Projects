import java.math.BigDecimal;
import java.math.RoundingMode;

public class main {
    public static void main(String[] args) {

        BigDecimal value;
        value = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(47),100, RoundingMode.HALF_UP);

        String alpha = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ ";
        char[] alphabet = alpha.toCharArray();
        String toCry = "УЁЙДПШЙФЯФЯИ ЧРРПМЮЭЗХКЗ ЧЛТЛТДМЩЙЦНЙЮ ЗШЧДКК";
        char[] toCrypt = toCry.toCharArray();
        StringBuilder result = new StringBuilder();

        int[] array = {16,10,41,11,22,01,81,01,20};

//        char letterToCrypt ;
//        char resultLetter;
//        int offset = 0;
//        int posInCrypt = 0;
//        int posInAlph = 0;
//
//        for (int i = 0; i < toCrypt.length; i++) {
//            letterToCrypt = toCrypt[i];
//            offset = value.toString().charAt(i+2) - '0';
//            if (alpha.indexOf(letterToCrypt) != 33) {
//                if (alpha.indexOf(letterToCrypt) >= offset)
//                    resultLetter = alpha.charAt(alpha.indexOf(letterToCrypt) - offset);
////                else resultLetter = alpha.charAt(33 + alpha.indexOf(letterToCrypt) - offset);
//                else resultLetter = letterToCrypt;
//            }
//            else resultLetter = letterToCrypt;
//
//            result.append(resultLetter);
//            System.out.println(offset+" "+resultLetter);
//        }

//        System.out.println(result);



//        long sum = 0l;
//        for (int i = 1;;i++) {
//            sum = 0l;
//            for (int j = 1; j <=i; j++) {
//                sum += 9 * pow(10,j-1);
//            }
//            if (sum % 47 == 0) {
//                System.out.println(sum + " " + i);
//                return;
//            }
//        }

    }
}