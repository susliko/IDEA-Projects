import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double res = 0;
        Scanner scanner = new Scanner(new StringReader("2 a1 3"));

            while (scanner.hasNext()) {
                try {
                res += Double.parseDouble(scanner.next());
                }
                catch (NumberFormatException n) {}
        }

        System.out.printf("%.6f", res);
    }

}
