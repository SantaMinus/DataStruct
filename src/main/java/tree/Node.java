package tree;

import exception.WrongValueException;

public class Node {
    private int data;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) throws WrongValueException {
        if (leftChild.data < this.data) {
            leftChild.parent = this;
            this.leftChild = leftChild;
        } else {
            throw new WrongValueException("Left child's data must be less than the parent's");
        }
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) throws WrongValueException {
        if (rightChild.data > this.data) {
            rightChild.parent = this;
            this.rightChild = rightChild;
        } else {
            throw new WrongValueException("Right child's data must be greater than the parent's");
        }
    }

    public int getData() {
        return data;
    }
}
