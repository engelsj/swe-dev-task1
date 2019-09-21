package Solution;

public class TreeNode {

    // value stored within node
    int val;
    // left child of this node
    TreeNode left;
    // right child of this node
    TreeNode right;

    // create a new node with value val
    public TreeNode(int val){
        this.val = val;
    }

    // create a new node with value val and child left and right
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
