package Solution.DAG;

public class DAGNode {
    private int v;
    private int weight;

    DAGNode (int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    int getV(){
        return v;
    }

    int getWeight(){
        return weight;
    }
}
