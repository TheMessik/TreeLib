package graph;

import org.w3c.dom.Node;

import java.util.List;

public abstract class Graph {
    protected List<Node> nodes;

    public List<Node> getAllNodes() {
        return nodes;
    }
}
