package Solution;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;

public class DevTaskOneSolutionDAG {

    Graph graph;
    public DevTaskOneSolutionDAG(Graph<Integer, DefaultEdge> graph){
        this.graph = graph;
    }

    public String printGraph(){
        return graph.toString();
    }


}
