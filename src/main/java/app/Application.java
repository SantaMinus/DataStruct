package app;

import exception.WrongValueException;
import tree.Node;

public class Application {
    public static void main(String[] args) throws WrongValueException {
        Node root = new Node(5);
        root.setLeftChild(new Node(3));
        root.setRightChild(new Node(7));
    }
}
