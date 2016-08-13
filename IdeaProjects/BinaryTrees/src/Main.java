import trees.BinarySearchTree;
import trees.RedBlackTree;

import java.util.function.Function;

class Main {

    public static void checkTime(Function<Integer,String > function, Integer key) {
        long timeNanos = System.nanoTime();
        function.apply(key);
        timeNanos = System.nanoTime() - timeNanos;
        System.out.println(timeNanos + " nanoSeconds");
    }
    public static void main(String[] args) {
        RedBlackTree<Integer, String> rbTree = new RedBlackTree<>();
        BinarySearchTree<Integer, String> bsTree = new BinarySearchTree<>();

    }
}