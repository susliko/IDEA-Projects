import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder res = new StringBuilder();
        int buffer;
        while ((buffer = reader.read()) > 0) res.append((char)buffer);
        return res.toString();
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = new ByteArrayInputStream(
                    new byte[]{48, 49, 50, 33});
            System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
        }
        catch (IOException e) { }
    }
}
