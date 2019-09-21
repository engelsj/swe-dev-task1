package Solution.Tree;

// Tree Node
public class Node{
    // data stored as an integer
    public Integer data;
    // left and right children of the node
    public Node left, right;

    // constuctor that creates a new node with null children
    Node(Integer data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
