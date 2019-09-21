package Tests;

import Solution.DevTaskOneSolution;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testStandardBinaryTreeInput() {
        DevTaskOneSolution solution = new DevTaskOneSolution();
        System.out.println(solution.lowestCommonAncestor(null, null, null));
    }
}