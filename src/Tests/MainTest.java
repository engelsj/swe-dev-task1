package Tests;

import Solution.DevTaskOneSolutionBST;
import Solution.Tree.BSTNode;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    // test will null inputs
    @Test
    public void testNullInput() {
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        Assert.assertNull(solution.lowestCommonAncestor(null, null,null));
    }

    // test with null root and not null nodes
    @Test
    public void testNullRoot(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(5);
        BSTNode root = null;
        Assert.assertNull(solution.lowestCommonAncestor(root, rightChild,rightChild));
    }

    // test with root with null childern
    @Test
    public void testRootWithNullChildren(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = null;
        BSTNode leftChild = null;
        BSTNode root = new BSTNode(1,rightChild,leftChild);
        Assert.assertNull(solution.lowestCommonAncestor(root, rightChild,rightChild));
    }

    // test with root with right null child
    // expected to get back not null child
    @Test
    public void testRootWithRightChild(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(2);
        BSTNode leftChild = null;
        BSTNode root = new BSTNode(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root, rightChild,rightChild), rightChild);
    }

    // test with root with left null child
    // expected to get back not null child
    @Test
    public void testRootWithLeftChild(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = null;
        BSTNode leftChild = new BSTNode(2);
        BSTNode root = new BSTNode(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), leftChild);
    }

    // test with same children value
    @Test
    public void testRootWithSameChildValue(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(2);
        BSTNode leftChild = new BSTNode(2);
        BSTNode root = new BSTNode(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), root);
    }

    // test with same value as children value
    @Test
    public void testRootWithSameValueAsChildren(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(2);
        BSTNode leftChild = new BSTNode(2);
        BSTNode root = new BSTNode(2,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), root);
    }

    // test with loopedChildren
    @Test
    public void testRootWithLoopedChildren(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(1);
        BSTNode root = new BSTNode(1,rightChild,rightChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithLoopedTree(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(1);
        BSTNode root = new BSTNode(1,rightChild,rightChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithLoopedChildTree(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(1);
        BSTNode leftChild = new BSTNode(2);
        rightChild.left = leftChild;
        leftChild.right = rightChild;
        BSTNode root = new BSTNode(1,rightChild,leftChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,leftChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithRootParameter(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode rightChild = new BSTNode(1);
        BSTNode leftChild = new BSTNode(2);
        BSTNode root = new BSTNode(3,rightChild,leftChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,leftChild,root), root);
    }

    // tests with a standard given tree
    @Test
    public void testStandardTree(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode eight = new BSTNode(8);
        BSTNode seven = new BSTNode(7);
        BSTNode five = new BSTNode (5, eight,seven);
        BSTNode three = new BSTNode(3, null,five);
        BSTNode six = new BSTNode(6);
        BSTNode four = new BSTNode(4, null,six);
        BSTNode two = new BSTNode(2, null, four);
        BSTNode root = new BSTNode(1,three,two);
        Assert.assertEquals(solution.lowestCommonAncestor(root,seven,eight), five);
        Assert.assertEquals(solution.lowestCommonAncestor(root,five,six), root);
    }

    // tests a balances binary search tree
    @Test
    public void testEvenTree(){
        DevTaskOneSolutionBST solution = new DevTaskOneSolutionBST();
        BSTNode four = new BSTNode(4);
        BSTNode five = new BSTNode(5);
        BSTNode two = new BSTNode(2, five, four);
        BSTNode six = new BSTNode(6);
        BSTNode three = new BSTNode(3, six, null);
        BSTNode root = new BSTNode(1, three, two);
        Assert.assertEquals(solution.lowestCommonAncestor(root,four,five), two);
        Assert.assertEquals(solution.lowestCommonAncestor(root,six,five), root);
    }
    
}