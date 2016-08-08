import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
            Object[] objects = stream.sorted(order).toArray();

        if (objects.length != 0)
        minMaxConsumer.accept( (T)objects[0], (T)objects[objects.length-1]);
        else
            minMaxConsumer.accept(null, null);
    }

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,5,4);
        Object[] obj = stream.sorted().toArray();
        for (Object o : obj) {
            System.out.println(o);
        }
    }
}
