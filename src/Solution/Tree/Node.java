package Solution.Tree;

// Tree Node
public class Node{
    // data stored as an integer
    public Integer data;
    // left and right children of the node
    public Node left, right;

    // constuctor that creates a new node with null children
    public Node(Integer data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // constuctor that creates a nude with children
    public Node(Integer data, Node right, Node left)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
