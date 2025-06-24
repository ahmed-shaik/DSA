package Graphs.Medium;

import java.util.*;

public class ShortestPathinUndirectedGraph {

    class Solution {
        // Function to find the shortest path from a source node to all other nodes
        public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
            int[] dist = new int[adj.size()];

            // Initialize all distances as -1 (unvisited)
            for (int i = 0; i < dist.length; i++) {
                dist[i] = -1;
            }

            // Distance to the source is 0
            dist[src] = 0;

            // Queue for BFS traversal
            Queue<Integer> q = new LinkedList<>();
            q.add(src);

            // Perform BFS
            while (!q.isEmpty()) {
                int node = q.poll();

                // Traverse the neighbors of the node
                for (int neighbor : adj.get(node)) {
                    // If the neighbor hasn't been visited yet
                    if (dist[neighbor] == -1) {
                        dist[neighbor] = dist[node] + 1; // Update distance
                        q.add(neighbor); // Add to the queue for further exploration
                    }
                }
            }

            return dist;
        }
    }

}
