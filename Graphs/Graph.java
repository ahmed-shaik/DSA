package Graphs;

import java.util.*;

public class Graph {
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

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

    public static boolean isCycleInUndirectedGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isCycleHelper(adj, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleHelper(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
        vis[curr] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr, -1));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.node;
            int parent = p.parent;
            for (int el : adj.get(node)) {
                if (!vis[el]) {
                    vis[el] = true;
                    q.add(new Pair(el, node));
                } else if (parent != el) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleInUndirectedGraphUsingDfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isCycleHelperDfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleHelperDfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, int p) {
        vis[curr] = true;
        for (int el : adj.get(curr)) {
            if (!vis[el]) {
                if (isCycleHelperDfs(adj, vis, el, curr)) {
                    return true;
                }
            } else if (p != el) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        ArrayList<Integer> topo = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfsForTopoSort(i, vis, st, adj);
            }
        }
        while (!st.isEmpty()) {
            topo.add(st.pop());
        }
        return topo;
    }

    public static void dfsForTopoSort(int node, boolean vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int el : adj.get(node)) {
            if (!vis[el]) {
                dfsForTopoSort(el, vis, st, adj);
            }
        }
        st.push(node);
    }

    public static ArrayList<Integer> topologicalSortUsingBfs(int v, ArrayList<ArrayList<Integer>> adj) {
        // khans algorithm
        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int el : adj.get(i)) {
                indegree[el]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for (int el : adj.get(node)) {
                indegree[el]--;
                if (indegree[el] == 0) {
                    q.add(el);
                }
            }
        }
        return topo;
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

        // Is cycle in undirected graph

        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < 6; i++) {
            adj1.add(new ArrayList<>());
        }
        /*
         * 0 - 1
         * | |
         * 2 - 3
         * | |
         * 4 - 5
         * 
         */

        // Adding edges (creating the graph with a cycle)
        adj1.get(0).add(1);
        adj1.get(1).add(0);
        adj1.get(1).add(3);
        adj1.get(3).add(1);
        adj1.get(3).add(2);
        adj1.get(2).add(3);
        adj1.get(2).add(0);
        adj1.get(0).add(2);
        adj1.get(5).add(4);
        adj1.get(4).add(5);

        System.out.println("Is cycle in undirected graph: " + isCycleInUndirectedGraph(adj1, v));

        System.out.println("Is cycle in undirected graph: " + isCycleInUndirectedGraphUsingDfs(adj1, v));

        System.out.println("Topo sort:" + topologicalSort(6, adj1));
    }
}
