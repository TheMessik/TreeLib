package binarytree;

import graph.Node;

import java.util.Random;

public class BinaryTreeNode<T extends Comparable<T>> extends Node<T> {
    public BinaryTreeNode(Node<T> parent, T item) {
        super(parent, item);
    }

    /**
     * Adds a new node to the current node
     * if the numbers of nodes is larger than 2, proceed to the next node
     *
     * @param value value to be added
     * @return the new node if adding was successful, null otherwise
     */
    @Override
    public Node<T> addNode(T value) {
        if (children.size() < 2) {
            Node<T> newChild = new BinaryTreeNode<T>(this, value);
            this.addNode(newChild);

            return newChild;
        }

        // pick a random child out of the current children
        Node<T> randomChild = this.children.get(new Random().nextInt(this.children.size()));

        return randomChild.addNode(value);
    }

    private void addNode(Node<T> node) {
        if (children.size() < 2) { // we can still add a node
            this.children.add(node);
        } else {

            // pick a random child out of the current children
            Node<T> randomChild = this.children.get(new Random().nextInt(this.children.size()));

            randomChild.addNode(node.getValue());
        }
    }

    @Override
    public int hashCode() {
        int randomPrime = 13; // chosen randomly

        int sum = this.children.stream()
                .map(Node::hashCode)
                .reduce(0, Integer::sum);

        return (this.value.hashCode() + sum) * randomPrime;
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Node<?>) {
            return ((Node<?>) that).getValue().equals(value);
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("BT(%s)", value));

        for(Node<T> child : children) {
            sb.append(":");
            sb.append(child.toString());
        }

        return sb.toString();
    }
}
