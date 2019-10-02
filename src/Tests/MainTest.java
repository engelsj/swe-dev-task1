package Tests;

import Solution.DevTaskOneSolution;
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
    public void test
}