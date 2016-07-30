public class main
{
    static final String alphabet = "АБВГДЕЁЖЗИЁКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    static String chAlphabet = "";

    static void changeAlphabet(int a, int b) {
        chAlphabet = "";
        for (int i = 0 ; i < alphabet.toCharArray().length; i++) {
            int pos = (a*i+b)%33;
            chAlphabet += alphabet.charAt(pos);
        }
    }

    static int posOfLetter(String letter) {
        return chAlphabet.indexOf(letter);
    }

    public static void main(String[] args) {

        String decode = "РЁАЁЦЯЁВГШГОТОМЬДЯПИПДЯОШЭДИОНОЦЬДЯПИ";


//        for (int a = 1222; a < 33; a++) {
//            if (a == 3 || a==11 || a==6 || a==9 || a==12 || a==15 || a==18 || a==21 || a==22 || a==24 || a==27 || a==30) continue;
//            for (int b = 0; b <= 32; b++) {

        changeAlphabet(16, 25);

//        System.out.println("a:" + a + " " + "b:" + b);
        String resString = "";

//        System.out.println(chAlphabet);

        for (int i = 0; i < decode.length(); i++) {
            resString += alphabet.charAt(posOfLetter(decode.substring(i, i + 1)));
        }

        System.out.println(resString);
//    }
//        }
//        for (int i = 0; i < 33;i++)
//            System.out.println((4*i+27)%33);
    }
}
