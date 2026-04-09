/*
 * Problem: Check if a graph is Bipartite
 * 
 * Online: https://leetcode.com/problems/is-graph-bipartite/
 * Approach:
 * - Use BFS traversal and color each node with 2 colors (0 and 1)
 * - Start from an unvisited node and assign color 0
 * - For every adjacent node:
 *      -> If not colored, assign opposite color
 *      -> If already colored and same as current, graph is NOT bipartite
 *
 * Key Idea:
 * - A graph is bipartite if we can divide vertices into 2 sets
 *   such that no two adjacent vertices have the same color
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * Note:
 * - Works for disconnected graphs as well (loop through all vertices)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartite {
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

        // 1-vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // initially no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                // BFS
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }

}
