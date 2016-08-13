package trees;

public abstract class BinaryTree<K extends Comparable<K>, V> {

    public final Node NULL = new Node();

    public class Node {
         private static final String RED = "RED";
         private static final String BLACK = "BLACK";
         private StringBuilder color;
         private K key;
         private V value;
         private Node left, right, parent;

        public Node() {
            setBlack();
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = NULL;
            right = NULL;
            parent = NULL;
            color = new StringBuilder(RED);
        }

        /* Getters for all Node's variables */
        public String getColor() { return color.toString(); }
        public K getKey() { return key; }
        public V getValue() { return value; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }
        public Node getParent() { return parent; }

        /* Setters for all Node's variables */
        public void setColor(String col) {color = (col.equals(BLACK)||col.equals(RED))?new StringBuilder(col):color;}
        public void setRed() {color = new StringBuilder(RED);}
        public void setBlack() {color = new StringBuilder(BLACK);}
        public void setKey(K key) { this.key = key;}
        public void setValue(V value) { this.value = value; }
        public void setLeft(Node node) { left = node; }
        public void setRight(Node node) { right = node; }
        public void setParent(Node node) { parent = node; }

        public boolean isBlack() {return color.toString().equals(BLACK);}
        public String toString() {
            return ("(" + key + ", " + value + ")");
        }
        public String toStringC() {
            return (((color.toString().equals(RED)) ? "R:" : "B:") + "(" + key + ", " + value + ")");
        }
    }



    private Node root = NULL;

    public void setRoot(Node root) { this.root = root; }

    /* Methods to be implemented in Classes-inheritors */
    public abstract void add(K key, V value);
    public abstract boolean remove(K key);

    /* GET-methods */
    public V getValue(K key) {
        Node root = getRoot();
        while (root != NULL) {
            if (key.compareTo(root.getKey()) == 0)
                return root.getValue();
            if (key.compareTo(root.getKey()) < 0)
                return getValue(key, root.getLeft());
            else return getValue(key, root.getRight());
        }
        return null;
    }
    public V getValue(K key, Node root) {
        while (root != NULL) {
            if (key.compareTo(root.getKey()) == 0)
                return root.getValue();
            if (key.compareTo(root.getKey()) < 0)
                return getValue(key, root.getLeft());
            else return getValue(key, root.getRight());
        }
        return null;
    }
    public Node getNode(K key) {
        Node root = getRoot();
        if (root == NULL || root.getKey().equals(key))
            return root;
        if (key.compareTo(root.getKey()) < 0)
            return getNode(key, root.getLeft());
        else
            return getNode(key, root.getRight());
    }
    public Node getNode(K key, Node root) {
        if (root == NULL || root.getKey().equals(key))
            return root;
        if (key.compareTo(root.getKey()) < 0)
            return getNode(key, root.getLeft());
        else
            return getNode(key, root.getRight());
    }
    public Node getRoot() { return root; }
    public Node getNull() { return NULL; }

    /* Default methods */

    public boolean containsKey(K key) {
        Node root = getRoot();
        while (root != NULL) {
            if (key.compareTo(root.getKey()) == 0)
                return true;
            if (key.compareTo(root.getKey()) < 0)
                return containsKey(key, root.getLeft());
            else return containsKey(key, root.getRight());
        }
        return false;
    }
    public boolean containsKey(K key, Node root) {
        while (root != NULL) {
            if (key.compareTo(root.getKey()) == 0)
                return true;
            if (key.compareTo(root.getKey()) < 0)
                return containsKey(key, root.getLeft());
            else return containsKey(key, root.getRight());
        }
        return false;
    }
    public Node max() {
        Node root = getRoot();
        while (root.getRight() != NULL) {
            return max(root.getRight());
        }
        return root;
    }
    public Node max(Node root) {
        while (root.getRight() != NULL) {
            return max(root.getRight());
        }
        return root;
    }
    public Node min() {
        Node root = getRoot();
        while (root.getLeft() != NULL) {
            return max(root.getLeft());
        }
        return root;
    }
    public Node min(Node root) {
        while (root.getLeft() != NULL) {
            return max(root.getLeft());
        }
        return root;
    }
    public Node treeSuccessor(Node node) {
        if (node.getRight() != NULL)
            return min(node.getRight());
        Node y = node.getParent();

        while (y != NULL && y.getRight() == node) {
            node = y;
            y = node.getParent();
        }
        return y;
    }
    public void printTree(Node root) {
        if (root != NULL) {
            printTree(root.getLeft());
            System.out.print(root.toString() + " ");
            printTree(root.getRight());
        }
        if (getRoot() == NULL) {
            System.out.println("Tree is empty!");
        }
    }
    public void printTree() {
        Node root = getRoot();
        if (root != NULL) {
            printTree(root.getLeft());
            System.out.print(root.toString() + " ");
            printTree(root.getRight());
        }
        if (getRoot() == NULL) {
            System.out.println("Tree is empty!");
        }
    }

}
