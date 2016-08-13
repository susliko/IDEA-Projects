package trees;

public class RedBlackTree<K extends Comparable<K>, V> extends BinaryTree<K, V>{

    public void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != NULL) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());

        if (x.getParent() == NULL) {
            setRoot(y);
        } else {
            if (x == x.getParent().getLeft()) {
                x.getParent().setLeft(y);
            }
             else{
                x.getParent().setRight(y);
            }
        }

        y.setLeft(x);
        x.setParent(y);
    }

    public void rightRotate(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != NULL) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());

        if (x.getParent() == NULL) {
            setRoot(y);
        } else {
            if (x == x.getParent().getLeft()) {
                x.getParent().setLeft(y);
            } else{
                x.getParent().setRight(y);
            }
        }

        y.setRight(x);
        x.setParent(y);

    }

    @Override
    public void add(K key, V value) {

        Node parent = NULL;
        Node currNode = getRoot();
        Node newNode = new Node(key, value);

        while (currNode != NULL) {
            parent = currNode;
            currNode = key.compareTo(currNode.getKey()) >= 0 ? currNode.getRight() : currNode.getLeft();
        }

        if (parent == NULL) {
            setRoot(newNode);
        } else {
            if (key.compareTo(parent.getKey()) >= 0) {
                parent.setRight(newNode);
            } else {
                parent.setLeft(newNode);
            }
            newNode.setParent(parent);
        }
        addFixup(newNode);
    }

    private void addFixup(Node nephew) {

        Node uncle;
        while (!nephew.getParent().isBlack()){
            if (nephew.getParent() == nephew.getParent().getParent().getLeft()) {
                uncle = nephew.getParent().getParent().getRight();
                if (!uncle.isBlack()) {
                    nephew.getParent().setBlack();
                    uncle.setBlack();
                    nephew.getParent().getParent().setRed();
                    nephew = nephew.getParent().getParent();
                } else {
                    if (nephew == nephew.getParent().getRight()){
                        nephew = nephew.getParent();
                        leftRotate(nephew);
                    }
                    nephew.getParent().setBlack();
                    nephew.getParent().getParent().setRed();
                    rightRotate(nephew.getParent().getParent());
                }
            } else {
                uncle = nephew.getParent().getParent().getLeft();
                if (!uncle.isBlack()) {
                    nephew.getParent().setBlack();
                    uncle.setBlack();
                    nephew.getParent().getParent().setRed();
                    nephew = nephew.getParent().getParent();
                } else {
                    if (nephew == nephew.getParent().getLeft()){
                        nephew = nephew.getParent();
                        rightRotate(nephew);
                    }
                    nephew.getParent().setBlack();
                    nephew.getParent().getParent().setRed();
                    leftRotate(nephew.getParent().getParent());
                }
            }
        }
        getRoot().setBlack();
    }
    @Override
    public boolean remove(K key) {
        Node lostChild, toDelete;
        Node toChange = getNode(key);

        if (toChange == NULL) return false;

        toDelete = (toChange.getLeft() == NULL || toChange.getRight() == NULL) ? toChange : treeSuccessor(toChange);
        lostChild = (toDelete.getLeft() != NULL) ? toDelete.getLeft() : toDelete.getRight();

        lostChild.setParent(toDelete.getParent());

        if (toDelete.getParent() == NULL) {
            setRoot(lostChild);
        } else {
            if (toDelete == toDelete.getParent().getLeft()) {
                toDelete.getParent().setLeft(lostChild);
            } else {
                toDelete.getParent().setRight(lostChild);
            }
        }

        if (toDelete != toChange) {
            toChange.setKey(toDelete.getKey());
            toChange.setValue(toDelete.getValue());
        }

        if (toDelete.isBlack()) {
            deleteFixup(lostChild);
        }

        return true;
    }

    private void deleteFixup(Node lostChild) {

        Node brother;

        while(lostChild != getRoot() && lostChild.isBlack()) {
            if (lostChild == lostChild.getParent().getLeft()) {
                brother = lostChild.getParent().getRight();

                if (!brother.isBlack()) {
                    brother.setBlack();
                    lostChild.getParent().setRed();
                    leftRotate(lostChild.getParent());
                    brother = lostChild.getParent().getRight();
                }

                if (brother.getLeft().isBlack() && brother.getRight().isBlack()) {
                    brother.setRed();
                    lostChild = lostChild.getParent();
                } else {
                    if (brother.getRight().isBlack()) {
                        lostChild.getLeft().setBlack();
                        brother.setRed();
                        rightRotate(brother);
                        brother = lostChild.getParent().getRight();
                    }
                    brother.setColor(lostChild.getParent().getColor());
                    lostChild.getParent().setBlack();
                    brother.getRight().setBlack();
                    leftRotate(lostChild.getParent());
                    lostChild = getRoot();
                }
            } else {
                brother = lostChild.getParent().getLeft();

                if (!brother.isBlack()) {
                    brother.setBlack();
                    lostChild.getParent().setRed();
                    rightRotate(lostChild.getParent());
                    brother = lostChild.getParent().getLeft();
                }

                if (brother.getRight().isBlack() && brother.getLeft().isBlack()) {
                    brother.setRed();
                    lostChild = lostChild.getParent();
                } else {
                    if (brother.getLeft().isBlack()) {
                        brother.getRight().setBlack();
                        brother.setRed();
                        leftRotate(brother);
                        brother = lostChild.getParent().getLeft();
                    }
                    brother.setColor(lostChild.getParent().getColor());
                    lostChild.getParent().setBlack();
                    brother.getLeft().setBlack();
                    rightRotate(lostChild.getParent());
                    lostChild = getRoot();
                }
            }
        }

        lostChild.setBlack();
    }

    @Override
    public void printTree(Node root) {
        if (root != NULL) {
            printTree(root.getLeft());
            System.out.print(root.toStringC () + " ");
            printTree(root.getRight());
        }
        if (getRoot() == NULL) {
            System.out.println("Tree is empty!");
        }
    }

    @Override
    public void printTree() {
        Node root = getRoot();
        if (root != NULL) {
            printTree(root.getLeft());
            System.out.print(root.toStringC() + " ");
            printTree(root.getRight());
        }
        if (getRoot() == NULL) {
            System.out.println("Tree is empty!");
        }

    }

}
