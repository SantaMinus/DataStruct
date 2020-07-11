package tree

import exception.WrongValueException
import spock.lang.Specification

class NodeTest extends Specification {

    def "setLeftChild() throws a WrongValueException when the arg's data is not less than the parent's"() {
        given:
        def node = new Node(5)

        when:
        node.setLeftChild(new Node(data))

        then:
        WrongValueException e = thrown()
        e.message == "Left child's data must be less than the parent's"

        where:
        data << [5, 6]
    }

    def "setLeftChild() sets a left child to the node"() {
        given:
        def node = new Node(5)

        when:
        node.setLeftChild(new Node(4))

        then:
        node.leftChild.data == 4
        node.leftChild.parent == node
    }

    def "setRightChild() throws a WrongValueException when the arg's data is not greater than the parent's"() {
        given:
        def node = new Node(5)

        when:
        node.setRightChild(new Node(data))

        then:
        WrongValueException e = thrown()
        e.message == "Right child's data must be greater than the parent's"

        where:
        data << [4, 5]
    }

    def "setRightChild() sets a right child to the node"() {
        given:
        def node = new Node(5)

        when:
        node.setRightChild(new Node(6))

        then:
        node.rightChild.data == 6
        node.rightChild.parent == node
    }
}
