/*
 * ============================================================
 *  GRAPH REPRESENTATION USING ADJACENCY LIST
 * ============================================================
 *
 *  A Graph is a data structure consisting of:
 *    - Vertices (V): Nodes/points in the graph
 *    - Edges (E): Connections between nodes, optionally weighted
 *
 *  IMPLEMENTATION: Adjacency List
 *    - Each vertex holds a list of its neighboring edges
 *    - Each Edge stores: source, destination, and weight
 *    - Space Complexity: O(V + E)
 *    - Preferred for sparse graphs over adjacency matrix
 *
 * ============================================================
 *  GRAPH DIAGRAM (Undirected, Weighted)
 * ============================================================
 *
 *        5           1
 *   0 ------- 1 --------- 2
 *             |          /|
 *           3 |        /  | 2
 *             |      / 1  |
 *             3 --- 2     4
 *
 *  Vertices : 0, 1, 2, 3, 4
 *
 *  Edges (with weights):
 *    0 <---(5)---> 1
 *    1 <---(1)---> 2
 *    1 <---(3)---> 3
 *    2 <---(1)---> 3
 *    2 <---(2)---> 4
 *
 *  Adjacency List Representation:
 *    0 -> [1(wt=5)]
 *    1 -> [0(wt=5), 2(wt=1), 3(wt=3)]
 *    2 -> [1(wt=1), 3(wt=1), 4(wt=2)]
 *    3 -> [1(wt=3), 2(wt=1)]
 *    4 -> [2(wt=2)]
 *
 * ============================================================
 */

import java.util.*;

public class Create {
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

    public static void main(String[] args) {
        int V = 5; // number of vertex

        // int arr[] = new arr[V]
        ArrayList<Edge>[] graph = new ArrayList[V]; // by default the arraylist will be null, so we have to turn that
                                                    // into empty arraylist

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 2));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        // for 2's neighbour
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }

    }
}
