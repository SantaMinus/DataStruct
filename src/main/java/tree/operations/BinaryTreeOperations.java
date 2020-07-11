package tree.operations;

import exception.TreeOperationException;
import tree.Node;

public class BinaryTreeOperations implements TreeOperations {

    @Override
    public void insertElement(Node element, Node root) throws TreeOperationException {
        if (element.getData() == root.getData()) {
            throw new TreeOperationException("Cannot contain equal element values");
        }
        if (element.getData() < root.getData()) {
            Node left = root.getLeftChild();
            if (left == null) {
                root.setLeftChild(element);
                element.setParent(root);
                return;
            }
            insertElement(element, root.getLeftChild());
        } else {
            Node right = root.getRightChild();
            if (right == null) {
                root.setRightChild(element);
                element.setParent(root);
                return;
            }
            insertElement(element, root.getRightChild());
        }
    }

    @Override
    public void removeElement() {
        // to be implemented
    }
}
