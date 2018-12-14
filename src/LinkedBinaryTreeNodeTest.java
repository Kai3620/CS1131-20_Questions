import static org.junit.Assert.*;

public class LinkedBinaryTreeNodeTest {

    private LinkedBinaryTreeNode root;

    @org.junit.Test
    public void getData() {
        // TODO make work for more than just root
        root.setData("Elephant");
        assertTrue("Unexpected return string", root.getData().equals("Elephant"));
    }

    @org.junit.Test
    public void setData() {
        root.setData("Elephant");
        assertTrue("Unexpected return string", root.getData().equals("Elephant"));
    }

    @org.junit.Test
    public void getRoot() {
        root.setData("Elephant");
        assertTrue("Unexpected return string", root.getData().equals("Elephant"));
    }

    @org.junit.Test
    public void getParent() {

    }

    @org.junit.Test
    public void getLeft() {
    }

    @org.junit.Test
    public void setLeft() {
    }

    @org.junit.Test
    public void getRight() {
    }

    @org.junit.Test
    public void setRight() {
    }

    @org.junit.Test
    public void isParent() {
    }

    @org.junit.Test
    public void isLeaf() {
    }

    @org.junit.Test
    public void hasLeftChild() {
    }

    @org.junit.Test
    public void hasRightChild() {
    }

    @org.junit.Test
    public void getDepth() {
    }

    @org.junit.Test
    public void getHeight() {
    }

    @org.junit.Test
    public void size() {
    }

    @org.junit.Test
    public void removeFromParent() {
    }

    @org.junit.Test
    public void pathTo() {
    }

    @org.junit.Test
    public void pathFrom() {
    }

    @org.junit.Test
    public void traversePreorder() {
    }

    @org.junit.Test
    public void traversePostorder() {
    }

    @org.junit.Test
    public void traverseInorder() {
    }

    @org.junit.Test
    public void setParent() {
    }
}