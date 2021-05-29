package binarytree;

import graph.Node;
import graph.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * A binary tree is a tree where every node has AT MOST 2 child nodes
 */
public class BinaryTree<T extends Comparable<T>> extends Tree<T> {

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(T initialValue) {
        this.root = new BinaryTreeNode<>(null, initialValue); // initialize the root
    }

    /**
     * Adds a new node to the tree
     *
     * @param value value of the node to be added
     * @return true if the addition was successful, false otherwise
     */
    @Override
    public Node<T> addNode(T value) {
        this.values.add(value);

        // if root has not been initialized yet
        if (this.root.getValue() == null) {
            this.nodes.add(root);

            this.root.setValue(value);

            return root;
        }

        // root has been initialized, so call on the root to add the value
        Node<T> newNode = root.addNode(value);

        this.nodes.add(newNode);

        return newNode;
    }

    /**
     * removes a node from the tree, based on value
     *
     * @param value the value of the node to be removed
     * @return true if the node was successfully removed, false otherwise
     */
    @Override
    public boolean removeNode(T value) {
        if (!this.values.contains(value)) {
            return false;
        }

        Node<T> node = findNode(value);

        List<Node<T>> children = new ArrayList<>(node.getChildren());

        // remove the node
        this.values.remove(value);
        this.nodes.remove(node);

        if(node.getParent() != null) {
            node.getParent().getChildren().remove(node);
            this.nodes.remove(node);
        } else { // if the value had no parent, it was the root node
            // set the root node to be the first node of the children list
            this.root = children.get(0);
        }

        // binary tree does not put any restrictions on what order the children are in the tree
        // re-introduce all children into the root

        // it could happen that we have removed the root node and set the first child to be the new root
        // if so, only reintroduce the other children, omitting the first one
        int start = 0;
        if(node.getParent() == null) {
            start = 1;
        }

        for (int i = start; i < children.size(); i++) {
            Node<T> child = children.get(i);
            this.root.addNode(child.getValue());
        }

        return true;
    }

    /**
     * Removes the passed node
     *
     * @param node node to be removed
     * @return true if the removal was successful, false otherwise
     */
    @Override
    public boolean removeNode(Node<T> node) {
        if (!this.nodes.contains(node)) {
            return false;
        }

        // remove the node
        this.values.remove(node.getValue());
        this.nodes.remove(node);
        node.getParent().getChildren().remove(node);

        // binary tree does not put any restrictions on what order the children are in the tree
        // re-introduce all children into the parent
        for (Node<T> child : node.getChildren()) {
            node.getParent().addNode(child.getValue());
        }

        return true;
    }

    /**
     * Finds the node with passed value
     *
     * @param value the value the required node should have
     * @return the required node if one is present, null otherwise
     */
    @Override
    public Node<T> findNode(T value) {
        if (!this.values.contains(value)) {
            return null;
        }

        // because Binary Tree does not put ANY restrictions on what order the children are in,
        // we need search through the entire tree
        // we shall perform a BFS to do this
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if (current.getValue().equals(value)) {
                return current;
            }

            for (Node<T> child : current.getChildren()) {
                queue.offer(child);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        if(nodes.size() == 0) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder();
        for(Node<T> n : nodes) {
            sb.append(n.toString());
        }

        return sb.toString();
    }
}
