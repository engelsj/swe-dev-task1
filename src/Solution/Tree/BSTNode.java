package Solution.Tree;

// Tree Node
public class BSTNode {
    // data stored as an integer
    public Integer data;
    // left and right children of the node
    public BSTNode left, right;

    // constuctor that creates a new node with null children
    public BSTNode(Integer data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // constuctor that creates a nude with children
    public BSTNode(Integer data, BSTNode right, BSTNode left)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
