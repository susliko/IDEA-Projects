import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class main {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T,? extends U> ifTrue,
            Function<? super T,? extends U> ifFalse) {
        IntStream.iterate().filter()
        return (a) -> (condition.test(a)) ? (ifTrue.apply(a)) : (ifFalse.apply(a));

    }

}
