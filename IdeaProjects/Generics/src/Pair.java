import java.util.Objects;

public class Pair<A,B> {

    private final A first;
    private final B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static<A,B> Pair<A,B> of (A first, B second) {
        return new Pair<>(first, second);
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Pair)) return false;

        Pair<A, B> other = (Pair<A, B>)obj;
        return (Objects.equals(other.first,first) && Objects.equals(other.second, second));
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Pair<?, ?> pair = (Pair<?, ?>) o;
//
//        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
//        return second != null ? second.equals(pair.second) : pair.second == null;
//
//    }
}

