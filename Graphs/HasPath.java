/*
 * Function: hasPath
 * Link: https://leetcode.com/problems/find-if-path-exists-in-graph/
 * -----------------
 * Determines whether there exists a path between a given source (src)
 * and destination (dest) in a graph using Depth First Search (DFS).
 *
 * Approach:
 * - Start DFS traversal from the source node.
 * - Mark the current node as visited.
 * - Recursively explore all unvisited neighbors.
 * - If at any point src == dest, return true.
 * - If no path is found after exploring all possibilities, return false.
 *
 * Parameters:
 * - graph[] : Adjacency list representation of the graph
 * - src     : Starting vertex
 * - dest    : Target vertex
 * - vis[]   : Boolean array to track visited nodes
 *
 * Returns:
 * - true  -> if a path exists from src to dest
 * - false -> otherwise
 *
 * Time Complexity:
 * - O(V + E), where V = vertices, E = edges
 *
 * Space Complexity:
 * - O(V) for visited array + recursion stack
 */

import java.util.ArrayList;

public class HasPath {
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
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5-vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6-vertex
        graph[6].add(new Edge(6, 5, 1));

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest)
            return true;

        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i); // e.dest -> neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}

// Leetcode version:
// class Solution {

// public boolean helper(ArrayList<ArrayList<Integer>> g, int src, int dest,
// boolean[] vis) {
// if (src == dest) return true;

// vis[src] = true;

// for (int nbr : g.get(src)) { // iterate neighbors of src
// if (!vis[nbr]) {
// if (helper(g, nbr, dest, vis)) {
// return true;
// }
// }
// }
// return false;
// }

// public boolean validPath(int n, int[][] edges, int source, int destination) {

// ArrayList<ArrayList<Integer>> g = new ArrayList<>();

// // initialize graph
// for (int i = 0; i < n; i++) {
// g.add(new ArrayList<>());
// }

// // build graph from edges
// for (int[] e : edges) {
// int u = e[0];
// int v = e[1];
// g.get(u).add(v);
// g.get(v).add(u); // undirected
// }

// return helper(g, source, destination, new boolean[n]);
// }
// }