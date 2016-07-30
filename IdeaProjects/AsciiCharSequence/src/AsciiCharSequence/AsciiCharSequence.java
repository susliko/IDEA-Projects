package AsciiCharSequence;

public class AsciiCharSequence implements java.lang.CharSequence {

    byte[] elements;

    public  AsciiCharSequence(byte[] elements) {

        this.elements = new byte[elements.length];
        this.elements = elements.clone();
    }

    public AsciiCharSequence(byte[] elements,int start, int length) {

        this.elements = new byte[length];
        for (int i = 0; i < this.elements.length; i++){
            this.elements[i] = elements[start+i];
        }
    }

    @Override
    public int length() {
        return elements.length;
    }

    @Override
    public char charAt(int index) {
        return (char) elements[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return  new AsciiCharSequence(elements,start,end-start);
    }

    @Override
    public String toString(){
        return new String(elements);
    }
}