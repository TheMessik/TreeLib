import binarytree.BinaryTree;
import binarytree.BinaryTreeNode;
import graph.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTests {
    BinaryTree<Integer> tree;

    @Before
    public void init() {
        this.tree = new BinaryTree<>();
    }

    @Test
    public void testAddition() {
        Node<Integer> n1 = tree.addNode(1);
        Node<Integer> n2 = tree.addNode(2);

        Assert.assertEquals(2, tree.getSize());
        Assert.assertEquals(n1, tree.findNode(1));
        Assert.assertEquals(n2, tree.findNode(2));
        Assert.assertNull(tree.findNode(3));
        Assert.assertEquals(1, tree.getRoot().getValue().intValue());
        Assert.assertEquals(2, tree.getRoot().getChildren().get(0).getValue().intValue());
    }

    @Test
    public void testAddition2() {
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);

        Assert.assertEquals(4, tree.getSize());
    }

    @Test
    public void testAddition3() {
        Node<Integer> n1 = new BinaryTreeNode<>(null, 1);
    }

    @Test
    public void testRemoval() {
        tree.addNode(1);
        tree.addNode(2);
        System.out.println(tree);

        tree.removeNode(1);
        System.out.println(tree);
        Assert.assertEquals(1, tree.getSize());
        Assert.assertEquals(2, tree.getRoot().getValue().intValue());
    }
}
