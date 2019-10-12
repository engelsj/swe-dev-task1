package Solution;


import org.jgrapht.Graph;
import org.jgrapht.alg.NaiveLcaFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import sun.security.provider.certpath.Vertex;

public class DevTaskOneSolutionDAG {

    Graph graph;
    public DevTaskOneSolutionDAG(Graph<Integer, DefaultEdge> graph){
        this.graph = graph;
    }

    public String printGraph(){
        return graph.toString();
    }

    public Integer findLca(Integer x , Integer y) {
        NaiveLcaFinder<Integer, DefaultEdge> naiveLcaFinder = new NaiveLcaFinder<>(graph);
        return  naiveLcaFinder.findLca(x, y);
    }




}
