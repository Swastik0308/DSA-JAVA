/**
 * PROBLEM: Number of Provinces (LeetCode 547)
 * Given an (n x n) adjacency matrix `isConnected`, where isConnected[i][j] = 1
 * means city i and city j are directly connected, return the total number of provinces.
 * A province is a group of cities directly or indirectly connected to each other.
 *
 * APPROACH: DFS on Undirected Graph
 * 1. Convert the adjacency matrix → adjacency list for easier graph traversal.
 * 2. Maintain a visited array to track which nodes have been explored.
 * 3. Loop through every node. If a node is unvisited, it's the start of a new
 *    province — increment counter and run DFS to mark all nodes in that province.
 * 4. DFS recursively visits all neighbors of a node, marking them visited,
 *    so they won't trigger a new province count in the outer loop.
 *
 * INTUITION: Think of each connected component as an island. We hop onto an
 * unvisited island (DFS), mark everything on it, then look for the next island.
 * The number of times we "hop" is the number of provinces.
 *
 * TIME COMPLEXITY:  O(V^2) — converting the matrix to adjacency list visits all cells.
 * SPACE COMPLEXITY: O(V^2) — adjacency list + O(V) visited array + O(V) recursion stack.
 *
 */


class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> g, int vis[]) {
        vis[node] = 1;
        for (Integer it : g.get(node)) {
            if (vis[it] == 0) {          
                dfs(it, g, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {   
                if (isConnected[i][j] == 1 && i != j) {  
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int province = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                province++;
                dfs(i, g, vis);
            }
        }
        return province;
    }
}
