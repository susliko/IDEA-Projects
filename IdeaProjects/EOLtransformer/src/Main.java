import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        byte buf;

//        byte[] in = new byte[] {13,13,13,10,13,10};
//        InputStream input =  new ByteArrayInputStream(in);
        while ((buf = (byte) System.in.read()) > 0) {

            if (buf != 13) System.out.write(buf );
            else {
                if ((buf = (byte) System.in.read()) == 10) System.out.write(10);
                else {
                    System.out.write(13);
                    System.out.write(buf);
                }
            }
        }
        System.out.flush();
    }
}
