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
        DirectedAcyclicGraph<Integer, DefaultEdge> graph = new DirectedAcyclicGraph<Integer, DefaultEdge>(DefaultEdge.class);
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG(graph);

        for(int i = 1; i < 14; i++)
            graph.addVertex(i);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(4,6);
        graph.addEdge(3,5);
        graph.addEdge(5,8);
        graph.addEdge(5,7);
        graph.addEdge(7,10);
        graph.addEdge(10,9);
        graph.addEdge(10,13);
        graph.addEdge(10,11);
        graph.addEdge(11,12);

        assertEquals(test.findLca(1,1), new Integer(1));
        assertEquals(test.findLca(2,3), new Integer(1));
        assertEquals(test.findLca(7,8), new Integer(5));
        assertEquals(test.findLca(9,10), new Integer(10));
        assertEquals(test.findLca(12,6), new Integer(1));
    }

    // tests with a standard DAG
    @Test
    public void testNormalCases() {
        DirectedAcyclicGraph<Integer, DefaultEdge> graph = new DirectedAcyclicGraph<Integer, DefaultEdge>(DefaultEdge.class);
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG(graph);


        for(int i = 1; i < 9; i++)
            graph.addVertex(i);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(6, 5);
        graph.addEdge(5, 8);

        assertEquals(new Integer(6), test.findLca(6, 8));
        assertEquals(new Integer(6), test.findLca(8, 6));
        assertEquals(new Integer(2), test.findLca(7, 8));
        assertEquals(new Integer(3), test.findLca(3, 3));
        assertEquals(new Integer(1), test.findLca(1, 5)); // tests one path not descending
    }

    // tests with an unreachable LCA
    @Test
    public void testNoLCA() {
        SimpleDirectedGraph<Integer, DefaultEdge> graph = new SimpleDirectedGraph<>(DefaultEdge.class);
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG(graph);

        for(int i = 1; i < 10; i++)
            graph.addVertex(i);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);

        assertEquals(null, test.findLca(9, 5));
    }

    // tests a graph with a loop
    @Test
    public  void testLoops() {
        Graph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG(graph);

        for(int i = 1; i < 10; i++)
            graph.addVertex(i);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(6, 5);
        graph.addEdge(5, 8);
        graph.addEdge(8, 5);
        graph.addEdge(8, 8);
        graph.addEdge(9, 9);

        assertEquals(new Integer(6), test.findLca(8, 6));
        assertEquals(null, test.findLca(1, 9));

    }


}