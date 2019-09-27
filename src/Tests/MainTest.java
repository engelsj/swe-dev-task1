package Tests;

import Solution.DevTaskOneSolution;
import Solution.Tree.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    // tests a generic binary tree with simple test case values
    @Test
    public void testStandardBinaryTree() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Tree tree = new Tree();
        Integer arr[] = {1,2,3,4,5,6,7};
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        assertEquals( solution.findLCA(4 ,5, tree.root), new Integer(2));
        assertEquals( solution.findLCA(4 ,6, tree.root), new Integer(1));
        assertEquals( solution.findLCA(3 ,4, tree.root), new Integer(1));
        assertEquals( solution.findLCA(2 ,4, tree.root), new Integer(2));
    }

    // tests with an empty binary tree
    @Test
    public void testEmptyBinaryTree() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Tree tree = new Tree();
        Integer arr[] = {};
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        assertEquals( solution.findLCA(4 ,6, tree.root), new Integer(-1));
    }

    // tests with a null binary tree
    @Test
    public void testNullBinaryTree() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Tree tree = new Tree();
        Integer arr[] = null;
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        assertEquals( solution.findLCA(4 ,6, tree.root), new Integer(-1));
    }

    // test with a one value tree
    @Test
    public void testSingleValueTree()
    {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Tree tree = new Tree();
        Integer arr[] = {1};
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        assertEquals( solution.findLCA(1 ,1, tree.root), new Integer(1));
    }
}