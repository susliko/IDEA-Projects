import java.util.function.DoubleUnaryOperator;

public class main {

    public static double integrate(DoubleUnaryOperator f, double a, double b, double step) {

        double result = 0;

        while (a<b){
            result += f.applyAsDouble(a)*step;
            a+=step;
        }
        return result;
    }

    public static double integResult(DoubleUnaryOperator f, double a, double b) {

        double step = 1;
        double epsilon = 1e-3,
                prev = integrate(f, a, b, step),
                next;
        while ( (next = integrate(f,a, b, step/2)) - prev > epsilon){
//            System.out.println(prev+" "+next);
            prev = next;
            step/=2;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(integResult(x ->
        {
            return Math.pow(x, 3);
        }, 0, 10));
    }

}
