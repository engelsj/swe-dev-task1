package Solution.DAG;

import java.util.LinkedList;

public class DAGGraph {
    private int v;
    private LinkedList<DAGNode>adj[];

    public DAGGraph(int v) {
       this.v = v;
       adj = new LinkedList[this.v];
       for(int i = 0; i < this.v; ++i)
           adj[i] = new LinkedList<DAGNode>();
    }

    void addEdge(int u, int v, int weight){
        DAGNode node = new DAGNode(v,weight);
        adj[u].add(node);
    }
}
