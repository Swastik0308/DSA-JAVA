/*
 * Cycle Detection in an Undirected Graph using DFS
 *
 * Approach:
 * - The graph is represented using an adjacency list.
 * - We perform Depth First Search (DFS) traversal.
 * - While traversing, we keep track of visited nodes.
 * - For each node, we also track its parent node in DFS.
 *
 * Key Idea:
 * - If we visit a node that is already visited AND is not the parent of the current node,
 *   then a cycle exists in the graph.
 *
 * Steps:
 * 1. Initialize a visited array.
 * 2. Traverse all components of the graph (to handle disconnected graphs).
 * 3. For each unvisited node, call DFS.
 * 4. During DFS:
 *    - Mark current node as visited.
 *    - Visit all neighbors:
 *        a) If neighbor is not visited → recursively DFS.
 *        b) If neighbor is visited and not parent → cycle detected.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) (visited array + recursion stack)
 *
 * Note:
 * - This approach works only for undirected graphs.
 * - For directed graphs, a different method (using recursion stack or Kahn’s algorithm) is required.
 */

import java.util.ArrayList;

public class CycleDetection {
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

        // for un-weighted grapgh, default weight will be 1

        // 0-vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true; // cycle detected
                }

            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            else if (vis[e.dest] && e.dest != par)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }

}
