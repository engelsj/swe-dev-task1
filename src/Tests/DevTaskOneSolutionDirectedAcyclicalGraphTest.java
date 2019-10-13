package Tests;

import Solution.DevTaskOneSolutionDAG;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class DevTaskOneSolutionDirectedAcyclicalGraphTest {


    //  testing from the example graph given in class
    @Test
    public void testExampleLCA(){
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(13);

        test.addEdge(1,2);
        test.addEdge(1,3);
        test.addEdge(2,4);
        test.addEdge(4,6);
        test.addEdge(3,5);
        test.addEdge(5,8);
        test.addEdge(5,7);
        test.addEdge(7,10);
        test.addEdge(10,9);
        test.addEdge(10,13);
        test.addEdge(10,11);
        test.addEdge(11,12);

        assertEquals(test.findLca(1,1), new Integer(1));
        assertEquals(test.findLca(2,3), new Integer(1));
        assertEquals(test.findLca(7,8), new Integer(5));
        assertEquals(test.findLca(9,10), new Integer(10));
        assertEquals(test.findLca(12,6), new Integer(1));
    }

    // tests with a standard DAG
    @Test
    public void testNormalCases() {
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(8);

        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(4, 5);
        test.addEdge(2, 6);
        test.addEdge(2, 7);
        test.addEdge(6, 5);
        test.addEdge(5, 8);

        assertEquals(new Integer(6), test.findLca(6, 8));
        assertEquals(new Integer(6), test.findLca(8, 6));
        assertEquals(new Integer(2), test.findLca(7, 8));
        assertEquals(new Integer(3), test.findLca(3, 3));
        assertEquals(new Integer(1), test.findLca(1, 5)); // tests one path not descending
    }

    // tests with an unreachable LCA
    @Test
    public void testNoLCA() {
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(10);

        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(4, 5);

        test.addEdge(6, 7);
        test.addEdge(6, 8);
        test.addEdge(7, 9);
        test.addEdge(8, 9);

        assertEquals(null, test.findLca(9, 5));
    }

    // tests a graph with a loop
    @Test
    public  void testLoops() {
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();

        test.addVertexes(9);

        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(4, 5);

        test.addEdge(2, 6);
        test.addEdge(2, 7);
        test.addEdge(6, 5);
        test.addEdge(5, 8);
        test.addEdge(8, 5);
        test.addEdge(8, 8);
        test.addEdge(9, 9);

        assertEquals(new Integer(6), test.findLca(8, 6));
        assertEquals(null, test.findLca(1, 9));
    }

    // tests when the graph is empty
    // the naiveLcaFinder seems to return the first vertex that if both x and y are equal to each other
    @Test
    public void testEmptyGraphSameVertex(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        assertEquals(new Integer(1), test.findLca(1, 1));
        assertEquals(new Integer(2), test.findLca(2, 2));
        assertEquals(new Integer(3), test.findLca(3, 3));
    }

    // tests when the graph is empty
    // the naiveLcaFinder throws an illegal argument exception when there are 2 different vertexes passed as parameters
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyGraphDifferentVertex(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        assertEquals(new Integer(1), test.findLca(1, 2));
        assertEquals(new Integer(2), test.findLca(2, 3));
        assertEquals(new Integer(3), test.findLca(3, 4));
    }

    // tests a graph with vertexes that do not have any connections
    @Test
    public void testGraphWithNoConnections(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(10);
        assertEquals(null, test.findLca(1, 2));
        assertEquals(null, test.findLca(2, 3));
        assertEquals(null, test.findLca(3, 4));
    }

    // tests the add vertex method with normal case
    @Test
    public void testAddVertexes(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(10);
        assertEquals(10, test.getNumberOfVertexes());
    }

    // tests the add vertex method with zero case
    @Test
    public void testAddVertexesZero(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(0);
        assertEquals(0, test.getNumberOfVertexes());
    }

    // tests the add vertex method with negative number
    @Test
    public void testAddVertexesNegative(){

        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(-1);
        assertEquals(0, test.getNumberOfVertexes());
    }

    // tests the add vertex method with max value number
    @Test
    public void testAddVertexesMaxValue(){
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(Integer.MAX_VALUE);
        assertEquals(0, test.getNumberOfVertexes());
    }

    // tests the add vertex method with max value number
    @Test
    public void testAddVertexesMinValue(){
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG();
        test.addVertexes(Integer.MIN_VALUE);
        assertEquals(0, test.getNumberOfVertexes());
    }

}