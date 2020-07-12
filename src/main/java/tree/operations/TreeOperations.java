package tree.operations;

import exception.TreeOperationException;
import exception.WrongValueException;
import tree.Node;

public interface TreeOperations {
    /**
     * Inserts a new element into a binary tree
     *
     * @param element
     *         a node to be inserted
     * @param root
     *         the tree root
     *
     * @throws TreeOperationException
     *         when there already exists a node with the same data
     */
    void insertElement(Node element, Node root) throws TreeOperationException;

    /**
     * Removes a specified element from a binary tree
     *
     * @param element
     *         a node to bw removed
     * @param root
     *         the tree root
     *
     * @throws WrongValueException
     */
    void removeElement(Node element, Node root) throws WrongValueException;
}
