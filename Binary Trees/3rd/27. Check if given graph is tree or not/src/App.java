// Complicated

import java.util.*;

class Graph {
    int v;
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isTree() {

        int visited[] = new int[v];

        if (isCycle(0, visited, -1))
            return false;

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0)
                return false;
        }
        return true;
    }

    boolean isCycle(int v, int[] visited, int parent) {
        visited[v] = 1;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            if (visited[i] == 0) {
                if (isCycle(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }

        return false;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        if (g.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
    }
}
