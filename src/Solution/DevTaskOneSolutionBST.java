package Solution;

import Solution.Tree.BSTNode;

public class DevTaskOneSolutionBST {

    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q){

        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        BSTNode left = lowestCommonAncestor(root.left, p , q);
        BSTNode right = lowestCommonAncestor(root.right, p , q);

        if(left != null && right != null)
            return root;
        else if(left == null && right == null)
            return null;
        else
            return left == null?right:left;
    }

}
