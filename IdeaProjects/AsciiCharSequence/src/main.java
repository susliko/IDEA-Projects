import AsciiCharSequence.*;

public class main {
    public static void main(String[] args) {
        byte[] b = {55,57,58,57,59,60};
        AsciiCharSequence s = new AsciiCharSequence(b);
        System.out.println(s.charAt(3)+"\n"
                            +s.toString() +"\n"
                            +s.length()+"\n"
                            +s.subSequence(1,2));
    }
}
