package Solution;

import Solution.Tree.Node;
import Solution.Tree.Tree;

public class DevTaskOneSolution {

    public Node lowestCommonAncestor(Node root, Node p, Node q){

        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        Node left = lowestCommonAncestor(root.left, p , q);
        Node right = lowestCommonAncestor(root.right, p , q);

        if(left != null && right != null)
            return root;
        else if(left == null && right == null)
            return null;
        else
            return left == null?right:left;
    }

}
