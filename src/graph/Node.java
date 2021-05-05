package graph;

import java.util.List;

public class Node {
    private final int item;
    private List<Node> children;

    public Node(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    public List<Node> getChildren() {
        return children;
    }
}
