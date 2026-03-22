/*
 * ============================================================
 *  BREADTH-FIRST SEARCH (BFS) ON AN UNDIRECTED GRAPH
 * ============================================================
 *
 *  BFS explores a graph level by level from a source vertex.
 *  It uses a Queue (FIFO) to process nodes and a visited[]
 *  boolean array to avoid revisiting nodes.
 *
 *  Time Complexity  : O(V + E) — every vertex and edge visited once
 *  Space Complexity : O(V)     — for the queue and visited array
 *
 * ============================================================
 *  GRAPH DIAGRAM (Undirected, Unweighted — default weight = 1)
 * ============================================================
 *
 *       0
 *      / \
 *     1   2
 *     |   |
 *     3   4
 *      \ /|
 *       X |
 *      / \|
 *     4   5
 *          \
 *           6
 *
 *  Cleaner view:
 *
 *    0 ------- 1
 *    |         |
 *    2         3
 *    |        / \
 *    4 ------+   5
 *             \ /
 *              6  (via 5)
 *
 *  Edges:
 *    0 <---> 1
 *    0 <---> 2
 *    1 <---> 3
 *    2 <---> 4
 *    3 <---> 4
 *    3 <---> 5
 *    4 <---> 5
 *    5 <---> 6
 *
 *  Adjacency List:
 *    0 -> [1, 2]
 *    1 -> [0, 3]
 *    2 -> [0, 4]
 *    3 -> [1, 4, 5]
 *    4 -> [2, 3, 5]
 *    5 -> [3, 4, 6]
 *    6 -> [5]
 *
 * ============================================================
 *  BFS TRAVERSAL (starting from vertex 0)
 * ============================================================
 *
 *  Step-by-step queue states:
 *
 *  Start : Queue = [0]   Visited = {}
 *  Pop 0 : Queue = [1,2] Visited = {0}       → print 0
 *  Pop 1 : Queue = [2,3] Visited = {0,1}     → print 1
 *  Pop 2 : Queue = [3,4] Visited = {0,1,2}   → print 2
 *  Pop 3 : Queue = [4,5] Visited = {0,1,2,3} → print 3
 *  Pop 4 : Queue = [5]   Visited = {...,4}   → print 4
 *  Pop 5 : Queue = [6]   Visited = {...,5}   → print 5
 *  Pop 6 : Queue = []    Visited = {...,6}   → print 6
 *
 *  Output: 0 1 2 3 4 5 6
 *
 * ============================================================
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    public static void bfs(ArrayList<Edge> graph[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); // source

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
