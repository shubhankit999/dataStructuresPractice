package Graph;

import java.util.LinkedList;

public class Graph {

    int v;
    LinkedList<Integer> adjListArray[];

    public Graph(int v) {
        this.v = v;
        adjListArray = new LinkedList[v];

        for(int i=0; i<v; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    public void printGraph(Graph graph) {
        for(int v=0; v<graph.v; v++) {
            System.out.println("Adjacency List of Vertex : " + v);
            System.out.print("head");
            for(Integer data : graph.adjListArray[v]) {
                System.out.print(" -> " + data);
            }
            System.out.println();
        }
    }
}
