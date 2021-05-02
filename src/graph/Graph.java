package graph;

import java.util.List;

public abstract class Graph {
    protected List<Node> nodes;

    public List<Node> getAllNodes() {
        return nodes;
    }
}
