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

    def "insertElement() creates a binary tree"() {
        given:
        def root = new Node(5)
        def n3 = new Node(3)
        def n1 = new Node(1)
        def n4 = new Node(4)
        def n0 = new Node(0)
        def n10 = new Node(10)
        def n17 = new Node(17)
        def n15 = new Node(15)
        def n12 = new Node(12)

        when:
        treeOps.insertElement(n3, root)
        treeOps.insertElement(n1, root)
        treeOps.insertElement(n10, root)
        treeOps.insertElement(n4, root)
        treeOps.insertElement(n0, root)
        treeOps.insertElement(n15, root)
        treeOps.insertElement(n17, root)
        treeOps.insertElement(n12, root)

        then:
        root.leftChild == n3
        root.rightChild == n10
        n3.leftChild == n1
        n3.rightChild == n4
        n1.leftChild == n0
        n10.rightChild == n15
        n15.leftChild == n12
        n15.rightChild == n17
    }

    def "removeElement() removes an end leaf"() {
        given:
        def root = new Node(5)
        treeOps.insertElement(l2, root)
        treeOps.insertElement(l3, root)

        when:
        treeOps.removeElement(l3, root)

        then:
        root.leftChild == left
        root.rightChild == right
        l3.rightChild == null

        where:
        l2           | l3           | left | right
        new Node(10) | new Node(15) | null | l2
        new Node(10) | new Node(8)  | null | l2
        new Node(3)  | new Node(1)  | l2   | null
        new Node(3)  | new Node(4)  | l2   | null
    }
}
