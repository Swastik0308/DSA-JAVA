/*
 * Topological Sorting using DFS (Depth First Search)
 *
 * Concept:
 * - Applicable only for Directed Acyclic Graphs (DAG)
 * - Idea: Perform DFS and push nodes to stack AFTER visiting all neighbors
 * - The stack gives the reverse of finishing times → valid topological order
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * Graph in this example:
 * 5 → 0
 * 5 → 2
 * 4 → 0
 * 4 → 1
 * 2 → 3
 * 3 → 1
 *
 * Key Insight:
 * - A node appears before its dependent nodes in the ordering
 * - DFS ensures dependencies are processed first before pushing to stack
 *
 * Note:
 * - Will NOT work correctly if the graph has a cycle
 */

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalDFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }

        }
        s.push(curr);
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);

        topSort(graph);
    }

}
