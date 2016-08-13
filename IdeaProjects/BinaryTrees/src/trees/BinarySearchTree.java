package trees;

public class BinarySearchTree<K extends Comparable<K>, V> extends BinaryTree<K, V> {

    @Override
    public void add(K key, V value) {

        Node newNode = new Node(key, value);
        Node parent = NULL;
        Node currNode = getRoot();

        while (currNode != NULL) {
            parent = currNode;
            currNode = key.compareTo(currNode.getKey()) < 0 ? currNode.getLeft() : currNode.getRight();
        }

        if (parent == NULL) {
            setRoot(newNode);
        } else {
            if (key.compareTo(parent.getKey()) < 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            newNode.setParent(parent);
        }
    }

    @Override
    public boolean remove(K key) {
        Node lostChild, toDelete;
        Node toChange = getNode(key, getRoot());

        if (toChange == NULL) return false;

        toDelete = (toChange.getLeft() == NULL || toChange.getRight() == NULL) ? toChange : treeSuccessor(toChange);
        lostChild = (toDelete.getLeft() == NULL) ? toDelete.getLeft() : toDelete.getRight();

        if (lostChild != NULL) lostChild.setParent(toDelete.getParent());

        if (toDelete.getParent() == NULL) {
            setRoot(lostChild);
        }
        else {
            if (toDelete == toDelete.getParent().getLeft()) {
                toDelete.getParent().setLeft(lostChild);
            }
            else {
                toDelete.getParent().setRight(lostChild);
            }
        }

        if (toDelete != toChange) {
            toChange.setKey(toDelete.getKey());
            toChange.setValue(toDelete.getValue());
        }

        return true;
    }
}
