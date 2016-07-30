import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class main {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int element;


        while ((element = inputStream.read()) >= 0) {

            sum = Integer.rotateLeft(sum, 1) ^ element;
            System.out.println(element + " " + sum);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        byte[] data = new byte[] { 0x33, 0x45, 0x01};
        InputStream inputStream = new ByteArrayInputStream(data);
        System.out.println(Arrays.toString(data));
        System.out.println(checkSumOfStream(inputStream));
    }
}
