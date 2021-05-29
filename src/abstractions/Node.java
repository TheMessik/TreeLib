package abstractions;

import java.util.ArrayList;
import java.util.List;

public abstract class Node<T extends Comparable<T>> {
    protected final List<Node<T>> children;
    protected T value;
    protected Node<T> parent;

    public Node(Node<T> parent, T value) {
        this.value = value;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public abstract Node<T> addNode(T value);

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract String toString();
}
