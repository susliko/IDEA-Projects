package lalala.papa;

public class stackk {
    public static void main(String[] args) {

//        System.out.println(getCallerClassAndMethodName());
        anotherMethodd();

    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }
    private static void anotherMethodd() {
        anotherMethod();
    }

    public static String getCallerClassAndMethodName() {

        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//        for (int i = 0; i < elements.length; i++) {
//            System.out.println(i+" : "+elements[i]);
//        }
        if (elements.length > 3)
            return (elements[3].getClassName()+"#"+elements[3].getMethodName());
        else return null;
    }

}
