package tree.operations

import spock.lang.Specification
import tree.Node

class BinaryTreeOperationsTest extends Specification {
    def treeOps = new BinaryTreeOperations()

    def "insertElement()"() {
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
}
