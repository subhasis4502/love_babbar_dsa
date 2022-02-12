/* Ref: https://www.youtube.com/watch?v=wuVwUK25Rfc */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] graph = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 0 },
                { 0, 2 }
        };
        int[] color = new int[graph.length];
        int node = 0;
        int m = 0;
        if (graphColoring(graph, color, node, m))
            System.out.println("Yes possible");
        else
            System.out.println("Not possible");
    }

    public static boolean graphColoring(int[][] graph, int[] color, int node, int m) {
        if (node == graph.length)
            return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, graph, color, i)) {
                color[node] = i;
                if (graphColoring(graph, color, node + 1, m))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int node, int[][] graph, int[] color, int col) {
        for (int i : graph[node]) {
            if (color[i] == col)
                return false;
        }
        return true;
    }
}
