package Graphs;

import java.util.*;

public class Graph {
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Breadth First Search (BFS) is an algorithm for traversing or searching
        // tree or graph data structures. It starts at the root (or an arbitrary node)
        // and explores all of the neighbor nodes at the present depth prior to moving
        // on to nodes at the next depth level.
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Starting from the first node
        vis[0] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            bfs.add(curr);
            for (int neighbor : adj.get(curr)) {
                if (!vis[neighbor]) { // If the neighbor has not been visited
                    vis[neighbor] = true; // Mark it as visited
                    q.add(neighbor); // Add the neighbor to the queue for future visits
                }
            }
        }
        return bfs;
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        dfsHelper(adj, dfs, 0, vis);
        return dfs;
    }

    public static void dfsHelper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, int curr, boolean vis[]) {
        vis[curr] = true;
        dfs.add(curr);
        for (int el : adj.get(curr)) {
            if (!vis[el]) {
                dfsHelper(adj, dfs, el, vis);
            }
        }
    }

    public static void main(String[] args) {
        // Graph is a network of nodes and edges
        // Stroing a graph in Java can be done using an
        // adjacency list
        // adjacency matrix.
        // edge list
        // 2d array(Implicit graph )

        // adjacency list
        // An adjacency list is a collection of lists or arrays

        // adjacency matrix
        // An adjacency matrix is a 2D array where the rows and columns
        // represent the nodes of the graph, and the values in the matrix
        // represent the edges between the nodes. If there is an edge
        // between node i and node j, then the value at matrix[i][j] is 1,
        // otherwise it is 0.

        // edge list
        // An edge list is a collection of edges, where each edge is represented
        // as a pair of nodes. For example, an edge between node i and node j
        // can be represented as a pair (i, j).

        int v = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list with empty lists for each vertex
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        // 0
        // / \
        // 1 2
        // | |
        // 3 4

        ArrayList<Integer> bfsResult = bfsOfGraph(v, adj);
        System.out.println("BFS of the graph: " + bfsResult);

        ArrayList<Integer> dfsResult = dfsOfGraph(adj, v);
        System.out.println("DFS of the graph: " + dfsResult);

    }
}
