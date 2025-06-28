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

    static class Pair1 {
        int node;
        int weight;

        Pair1(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void dfsForShortestPath(int node, boolean vis[], Stack<Integer> st, ArrayList<ArrayList<Pair1>> adj) {
        vis[node] = true;
        for (Pair1 el : adj.get(node)) {
            if (!vis[el.node]) {
                dfsForShortestPath(el.node, vis, st, adj);
            }
        }
        st.push(node);
    }

    public static int[] shortestPathinDirectedAcyclicGraph(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair1(v, wt));
        }
        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfsForShortestPath(i, vis, st, adj);
            }
        }
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0; // Assuming the source node is 0
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).weight;
                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1; // If no path exists, set distance to -1
            }
        }
        return dist;
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair2 implements Comparable<Pair2> {
        int n;
        int path;

        Pair2(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair2 p2) {
            return this.path - p2.path;
        }
    }

    public static int[] dijkistras(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];

        // Initialize distances
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Priority Queue to store nodes and their distances
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(src, 0));

        while (!pq.isEmpty()) {
            Pair2 p = pq.remove();

            // Relaxation step: Update distances for all adjacent vertices
            for (int i = 0; i < graph[p.n].size(); i++) {
                Edge e = graph[p.n].get(i);

                // Check if the new path is shorter
                if (dist[p.n] + e.wt < dist[e.dest]) {
                    dist[e.dest] = dist[p.n] + e.wt;
                    pq.add(new Pair2(e.dest, dist[e.dest]));
                }
            }
        }
        return dist;
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if (dist[j] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }
    }

    static class Pair3 implements Comparable<Pair3> {
        int v;
        int cost;

        Pair3(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair3 p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair3> pq = new PriorityQueue<>();
        pq.add(new Pair3(0, 0)); // Start from the first node
        int totalCost = 0;
        while (!pq.isEmpty()) {
            Pair3 p = pq.remove();
            int node = p.v;
            int cost = p.cost;
            if (!vis[node]) {
                vis[node] = true;
                totalCost += cost;
                for (Edge e : graph[node]) {
                    if (!vis[e.dest]) {
                        pq.add(new Pair3(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Total cost of Minimum Spanning Tree: " + totalCost);
    }

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i; // Initially, each element is its own parent
            rank[i] = 0; // Initial rank is 0
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x; // If x is its own parent, return x
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rank[rootA] == rank[rootB]) {
            par[b] = rootA; // Make a the parent of b
            rank[rootA]++; // Increment the rank of a
        } else if (rank[rootA] < rank[rootB]) {
            par[rootA] = rootB; // Make b the parent of a
        } else {
            par[rootB] = rootA; // Make a the parent of b
        }
    }

    // kruskal's algorithm
    class Solution {
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            // Code Here.
            int[] rank = new int[V]; // Rank for union-find
            int[] par = new int[V]; // Parent array for union-find
            for (int i = 0; i < V; i++) {
                par[i] = i; // Initially, each node is its own parent
                rank[i] = 0; // Initially, each node has rank 0
            }

            // Step 1: Collect all edges from adjacency list
            List<int[]> edges = new ArrayList<>();
            for (int u = 0; u < V; u++) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0]; // The other node in the edge
                    int weight = neighbor[1]; // The weight of the edge
                    edges.add(new int[] { u, v, weight }); // Add edge (u, v, weight)
                }
            }

            // Step 2: Sort edges by weight
            edges.sort(Comparator.comparingInt(a -> a[2])); // Sort by edge weight

            int mstWeight = 0; // Total weight of the MST
            int edgesUsed = 0; // Count of edges used in MST

            // Step 3: Process each edge
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // If u and v are in different sets, union them and add the edge to the MST
                if (find(u, par) != find(v, par)) {
                    union(u, v, par, rank); // Union the sets
                    mstWeight += weight; // Add edge weight to MST
                    edgesUsed++;

                    // If we have added V-1 edges, the MST is complete
                    if (edgesUsed == V - 1) {
                        break;
                    }
                }
            }

            return mstWeight; // Return the total weight of the MST
        }

        // Find with path compression
        public static int find(int x, int[] par) {
            if (par[x] == x) {
                return x;
            }
            return par[x] = find(par[x], par); // Path compression
        }

        // Union by rank
        public static void union(int a, int b, int[] par, int[] rank) {
            int rootA = find(a, par);
            int rootB = find(b, par);
            if (rootA != rootB) {
                // Union by rank
                if (rank[rootA] == rank[rootB]) {
                    par[rootB] = rootA;
                    rank[rootA]++;
                } else if (rank[rootA] < rank[rootB]) {
                    par[rootA] = rootB;
                } else {
                    par[rootB] = rootA;
                }
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

        // Minimum Spanning Tree (MST)
        // A minimum spanning tree (MST) or minimum weight spanning tree is a subset of
        // the
        // edges of a connected, edge-weighted undirected graph that connects all the
        // vertices
        // together, without any cycles and with the minimum possible total edge weight.

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        prims(graph);

        // Disjoint Set (Union-Find)
        // Disjoint Set is a data structure that keeps track of a set of elements
        // partitioned into a number of disjoint (non-overlapping) subsets.

        init();
        union(1, 3);
        System.out.println("Find 0: " + find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println("Find 1: " + find(3));
        System.out.println("Find 2: " + find(4));
        union(1, 5);
    }
}
