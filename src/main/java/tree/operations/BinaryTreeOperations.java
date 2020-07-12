package tree.operations;

import exception.TreeOperationException;
import exception.WrongValueException;
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
    public void removeElement(Node element, Node root) throws WrongValueException {
        Node left = element.getLeftChild();
        Node right = element.getRightChild();
        if (left == null && right == null) {
            if (element.getParent().getLeftChild() == element) {
                element.getParent().setLeftChild(null);
            } else {
                element.getParent().setRightChild(null);
            }
        } else if ((left != null && right == null)) {
            if (element.getParent().getLeftChild() == element) {
                element.getParent().setLeftChild(left);
            } else {
                element.getParent().setRightChild(left);
            }
        } else if (right != null && left == null) {
            if (element.getParent().getLeftChild() == element) {
                element.getParent().setLeftChild(right);
            } else {
                element.getParent().setRightChild(right);
            }
        } else {
            // to be implemented
        }
    }
}
