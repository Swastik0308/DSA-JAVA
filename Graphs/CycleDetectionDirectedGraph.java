/*
 * Detect Cycle in a Directed Graph using DFS (Recursion + Recursion Stack)
 *
 * Online: https://leetcode.com/problems/course-schedule/
 * Approach:
 * - We use Depth First Search (DFS) to traverse the graph.
 * - Two boolean arrays are maintained:
 *      1. vis[]   → to track visited nodes
 *      2. stack[] → to track nodes in the current DFS recursion stack
 *
 * - For each unvisited node, we start DFS:
 *      → Mark current node as visited and add it to recursion stack.
 *
 * - For every adjacent node:
 *      → If it is already in the recursion stack → cycle detected.
 *      → If not visited, recursively check for cycle.
 *
 * - After exploring all neighbors, remove the node from recursion stack.
 *
 * Key Idea:
 * - A cycle exists if we reach a node that is already in the current DFS path.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) (for visited array + recursion stack)
 *
 * Example:
 * - Graph: 0 → 2 → 3 → 0 forms a cycle
 *
 */

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
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

        // 0-vertex
        graph[0].add(new Edge(0, 2, 1));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0, 1));

    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }

}

// Leetcode version

// class Solution {
// public boolean canFinish(int numCourses, int[][] prerequisites) {
// ArrayList<Integer>[] graph = new ArrayList[numCourses];

// for (int i = 0; i < numCourses; i++) {
// graph[i] = new ArrayList<>();
// }

// // build graph
// for (int[] p : prerequisites) {
// int a = p[0];
// int b = p[1];
// graph[b].add(a); // b → a
// }

// boolean[] vis = new boolean[numCourses];
// boolean[] stack = new boolean[numCourses];

// for (int i = 0; i < numCourses; i++) {
// if (!vis[i]) {
// if (dfs(graph, i, vis, stack)) {
// return false; // cycle found
// }
// }
// }

// return true;
// }

// public boolean dfs(ArrayList<Integer>[] graph, int curr, boolean[] vis,
// boolean[] stack) {
// vis[curr] = true;
// stack[curr] = true;

// for (int nei : graph[curr]) {
// if (stack[nei]) return true;
// if (!vis[nei] && dfs(graph, nei, vis, stack)) return true;
// }

// stack[curr] = false;
// return false;
// }
// }
