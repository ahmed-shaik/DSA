package Graphs.Medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    class Solution {

        static class Pair implements Comparable<Pair> {
            int to, dist;

            Pair(int t, int d) {
                to = t;
                dist = d;
            }

            @Override
            public int compareTo(Pair p) {
                return this.dist - p.dist;
            }
        }

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            // Create the adjacency list for the graph
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            // Fill adjacency list with edges
            for (int[] edge : edges) {
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                adj.get(edge[1]).add(new Pair(edge[0], edge[2])); // Since it's an undirected graph
            }

            // Find the city with the smallest reachable cities
            int resultCity = -1;
            int minReachableCities = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int reachableCities = dijkstra(adj, i, distanceThreshold);
                if (reachableCities < minReachableCities) {
                    minReachableCities = reachableCities;
                    resultCity = i;
                } else if (reachableCities == minReachableCities && i > resultCity) {
                    resultCity = i;
                }
            }

            return resultCity;
        }

        // Dijkstra's algorithm to find the number of cities reachable from 'src' within
        // the distance threshold
        public static int dijkstra(ArrayList<ArrayList<Pair>> adj, int src, int threshold) {
            int n = adj.size();
            int[] dist = new int[n];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[src] = 0; // Distance to itself is 0

            // Min-heap priority queue to store (node, distance) pairs
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src, 0));

            while (!pq.isEmpty()) {
                Pair curr = pq.poll(); // Get the node with the smallest distance
                int node = curr.to;
                int currentDist = curr.dist;

                // If the current distance is greater than the threshold, no need to explore
                // further
                if (currentDist > threshold) {
                    continue;
                }

                // Explore neighbors
                for (Pair neighbor : adj.get(node)) {
                    int newDist = currentDist + neighbor.dist;
                    if (newDist < dist[neighbor.to]) {
                        dist[neighbor.to] = newDist;
                        pq.add(new Pair(neighbor.to, newDist)); // Add the neighbor with updated distance
                    }
                }
            }

            // Count the number of reachable cities
            int reachableCities = 0;
            for (int d : dist) {
                if (d <= threshold) {
                    reachableCities++;
                }
            }

            return reachableCities - 1; // Exclude the city itself
        }
    }
}
