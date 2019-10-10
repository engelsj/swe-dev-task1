package Tests;

import Solution.DevTaskOneSolutionDAG;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class DevTaskOneSolutionDirectedAcyclicalGraphTest {


    @Test
    public void testPrintGraph(){
        Graph<Integer, DefaultEdge> graph;
        graph = new DirectedAcyclicGraph<Integer, DefaultEdge>(DefaultEdge.class);

        for(int i = 0; i < 14; i++)
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
        DevTaskOneSolutionDAG test = new DevTaskOneSolutionDAG(graph);

        assertEquals(test.printGraph(), "([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13], " +
                "[(1,2), (1,3), (2,4), (4,6), (3,5), (5,8), (5,7), (7,10), (10,9), (10,13), (10,11), (11,12)])");
    }
}