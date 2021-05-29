package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Tree<T extends Comparable<T>> {
    protected Node<T> root;
    protected List<Node<T>> nodes;
    protected Set<T> values;

    public Tree() {
        this.nodes = new ArrayList<>();
        this.values = new HashSet<>();
    }

    public List<Node<T>> getAllNodes() {
        return nodes;
    }

    public int getSize() {
        return nodes.size();
    }

    public Node<T> getRoot() {
        return root;
    }

    public abstract Node<T> addNode(T value);
    public abstract boolean removeNode(T value);
    public abstract boolean removeNode (Node<T> n);
    public abstract Node<T> findNode(T value);
    public abstract String toString();
}
