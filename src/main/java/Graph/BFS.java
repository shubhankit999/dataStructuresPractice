package Graph;

import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {

        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.findCycle(2);
    }
}

class DirectedGraph {

    int v;
    LinkedList<Integer> adjListArray[];

    public DirectedGraph(int v) {
        this.v = v;
        adjListArray = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
    }

    public void bfs(int s) {

        boolean visited[] = new boolean[v];

        visited[s] = true;

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);
        while (queue.size() != 0) {

            s = queue.poll();
            System.out.println(s);
            for (Integer k : adjListArray[s]) {
                if (!visited[k]) {
                    visited[k] = true;
                    queue.add(k);
                }
            }
        }
    }

    public void dfs(int s) {

        boolean visited[] = new boolean[v];
        addElement(s, visited);

    }

    public void addElement(int s, boolean visited[]) {

        visited[s] = true;
        System.out.println(s);
        for (Integer k : adjListArray[s]) {
            if (!visited[k]) {
                addElement(k, visited);
            }
        }
    }

    public void findCycle(int s) {

        boolean visited[] = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        //System.out.println(isCycle(s, visited, stack));

    }


//    public boolean isCycle(int s, boolean visited[], LinkedList<Integer> stack) {
//
//        if (visited[s]) {
//            return false;
//        }
//        if (stack.contains(s)) {
//            return true;
//        }
//        visited[s] = true;
//        stack.push(s);
//        System.out.println(s);
//        for (Integer k : adjListArray[s]) {
//            if (isCycle(k, visited, stack)) {
//                return true;
//            }
//            stack.remove(k);
//            return false;
//        }
//    }

    public void print() {
        for (int i = 0; i < v; i++) {
            System.out.println("Adjacency List of Vertex : " + i);
            System.out.print("head");
            for (Integer k : adjListArray[i]) {
                System.out.print(" -> " + k);
            }
            System.out.println();
        }
    }

}
