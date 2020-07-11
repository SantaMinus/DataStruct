package tree.operations

import spock.lang.Specification
import tree.Node

class BinaryTreeOperationsTest extends Specification {
    def treeOps = new BinaryTreeOperations()

    def "insertElement() inserts a smaller element to the left"() {
        given:
        def root = new Node(5)

        when:
        treeOps.insertElement(new Node(data), root)

        then:
        root.leftChild.data == data
        root.leftChild.parent == root

        where:
        data << [-10, -5, -1, 0, 1, 4]
    }

    def "insertElement() inserts a bigger element to the right"() {
        given:
        def root = new Node(5)

        when:
        treeOps.insertElement(new Node(data), root)

        then:
        root.rightChild.data == data
        root.rightChild.parent == root

        where:
        data << [6, 10, 100, 500]
    }
}
