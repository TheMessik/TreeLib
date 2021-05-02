package graph;

import java.util.List;

public abstract class Node {
    private final String item;
    private List<Node> children;

    public Node(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public List<Node> getChildren() {
        return children;
    }
}
