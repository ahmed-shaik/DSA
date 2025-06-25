package Graphs.Medium;

import java.util.*;

public class CheapestFlightsWithinKStops {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Tuple {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            // Step 1: Create the adjacency list to represent the graph (flights)
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            // Populate the adjacency list with flight information
            for (int i = 0; i < flights.length; i++) {
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }

            // Step 2: Initialize the queue and the distance array
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, src, 0)); // Start from src with 0 stops and 0 cost

            // Initialize distance array with a large value
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            // Step 3: BFS-like search with stops limit using the queue
            while (!q.isEmpty()) {
                Tuple it = q.poll();
                int stops = it.first; // Number of stops
                int node = it.second; // Current node (airport)
                int cost = it.third; // Accumulated cost

                // If the number of stops exceeds the allowed K, continue to the next iteration
                if (stops > K)
                    continue;

                // Step 4: Process all adjacent airports
                for (Pair iter : adj.get(node)) {
                    int adjNode = iter.first; // Destination node (airport)
                    int edgeWeight = iter.second; // Cost of the flight

                    // Step 5: Relaxation condition: update cost if a cheaper path is found
                    if (cost + edgeWeight < dist[adjNode] && stops <= K) {
                        dist[adjNode] = cost + edgeWeight;
                        q.add(new Tuple(stops + 1, adjNode, dist[adjNode])); // Add to queue with updated cost and stops
                    }
                }
            }

            // Step 6: Return the result: if destination is unreachable, return -1
            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }
    }

}
