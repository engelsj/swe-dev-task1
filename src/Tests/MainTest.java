package Tests;

import Solution.DevTaskOneSolution;
import Solution.Tree.Tree;
import org.junit.Test;

public class MainTest {

    // tests a generic binary tree
    @Test
    public void testStandardBinaryTreeInput() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        Tree tree = new Tree();
        Integer arr[] = { 3,5,1,6,2,0,8, null, null ,7,4 };
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        tree.inOrder(tree.root);
    }
}