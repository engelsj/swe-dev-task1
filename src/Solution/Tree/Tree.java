package Solution.Tree;

public class Tree {
    public Node root;
    // Function to insert nodes in level order
    public Node insertLevelOrder(Integer[] arr, Node root, Integer i){
        // Base case for recursion
        if(arr != null) {
            if (i < arr.length) {
                Node temp = new Node(arr[i]);
                root = temp;

                // insert left child
                root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

                // insert right child
                root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
            }
            return root;
        }
        return null;
    }
}
