package Tests;

import Solution.DevTaskOneSolution;
import Solution.Tree.Node;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    // test will null inputs
    @Test
    public void testNullInput() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Assert.assertNull(solution.lowestCommonAncestor(null, null,null));
    }

    // test with null root and not null nodes
    @Test
    public void testNullRoot(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(5);
        Node leftChild = new Node(6);
        Node root = null;
        Assert.assertNull(solution.lowestCommonAncestor(root, rightChild,rightChild));
    }

    // test with root with null childern
    @Test
    public void testRootWithNullChildren(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = null;
        Node leftChild = null;
        Node root = new Node(1,rightChild,leftChild);
        Assert.assertNull(solution.lowestCommonAncestor(root, rightChild,rightChild));
    }

    // test with root with right null child
    // expected to get back not null child
    @Test
    public void testRootWithRightChild(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(2);
        Node leftChild = null;
        Node root = new Node(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root, rightChild,rightChild), rightChild);
    }

    // test with root with left null child
    // expected to get back not null child
    @Test
    public void testRootWithLeftChild(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = null;
        Node leftChild = new Node(2);
        Node root = new Node(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), leftChild);
    }

    // test with same children value
    @Test
    public void testRootWithSameChildValue(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(2);
        Node leftChild = new Node(2);
        Node root = new Node(1,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), root);
    }

    // test with same value as children value
    @Test
    public void testRootWithSameValueAsChildren(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(2);
        Node leftChild = new Node(2);
        Node root = new Node(2,rightChild,leftChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,leftChild), root);
    }

    // test with loopedChildren
    @Test
    public void testRootWithLoopedChildren(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(1);
        Node root = new Node(1,rightChild,rightChild);
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithLoopedTree(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(1);
        Node root = new Node(1,rightChild,rightChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,rightChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithLoopedChildTree(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(1);
        Node leftChild = new Node(2);
        rightChild.left = leftChild;
        leftChild.right = rightChild;
        Node root = new Node(1,rightChild,leftChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,leftChild,rightChild), root);
    }

    // test with looped tree
    @Test
    public void testRootWithRootParameter(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node rightChild = new Node(1);
        Node leftChild = new Node(2);
        Node root = new Node(3,rightChild,leftChild);
        rightChild.right = root;
        Assert.assertEquals(solution.lowestCommonAncestor(root,leftChild,root), root);
    }

    // tests with a standard given tree
    @Test
    public void testStandardTree(){
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Node eight = new Node(8);
        Node seven = new Node(7);
        Node five = new Node (5, eight,seven);
        Node three = new Node(3, null,five);
        Node six = new Node(6);
        Node four = new Node(4, null,six);
        Node two = new Node(2, null, four);
        Node root = new Node(1,three,two);
        Assert.assertEquals(solution.lowestCommonAncestor(root,seven,eight), five);
        Assert.assertEquals(solution.lowestCommonAncestor(root,five,six), root);
    }

}