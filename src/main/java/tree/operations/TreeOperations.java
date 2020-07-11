package tree.operations;

import exception.TreeOperationException;
import tree.Node;

public interface TreeOperations {

    void insertElement(Node element, Node root) throws TreeOperationException;

    void removeElement();
}
