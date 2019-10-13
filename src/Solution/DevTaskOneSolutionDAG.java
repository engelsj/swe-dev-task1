package Solution;


import org.jgrapht.Graph;
import org.jgrapht.alg.NaiveLcaFinder;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class DevTaskOneSolutionDAG {

    Graph graph;
    public DevTaskOneSolutionDAG(){
        this.graph = new DefaultDirectedGraph<>(DefaultEdge.class);;
    }

    public void addVertexes(int numberOfVertexes){
        if(numberOfVertexes >= 0)
            for(int i = 1; i < numberOfVertexes + 1; i++)
                graph.addVertex(i);
    }

    public  void addEdge(int x, int y){
        graph.addEdge(x,y);
    }

    public int getNumberOfVertexes(){
        return graph.vertexSet().size();
    }

    /*
    1. Start at each of nodes you wish to find the lca for (a and b)
    2. Create sets aSet containing a, and bSet containing b
    3. If either set intersects with the union of the other sets previous values (i.e. the set of notes visited) then
    that intersection is LCA. if there are multiple intersections then the earliest one added is the LCA.
    4. Repeat from step 3, with aSet now the parents of everything in aSet, and bSet the parents of everything in bSet
    5. If there are no more parents to descend to then there is no LCA
     */
    public Integer findLca(Integer x , Integer y) {
        NaiveLcaFinder<Integer, DefaultEdge> naiveLcaFinder = new NaiveLcaFinder<>(graph);
        return  naiveLcaFinder.findLca(x, y);
    }




}
