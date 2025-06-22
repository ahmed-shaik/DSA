package Graphs.Medium;

public class IsGraphBipartite {

    class Solution {
        public boolean isBipartite(int[][] graph) {
            int color[] = new int[graph.length];
            Arrays.fill(color, -1);
            for (int i = 0; i < graph.length; i++) {
                if (color[i] == -1) {
                    if (bfs(i, color, graph) == false) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean bfs(int curr, int[] color, int[][] graph) {
            color[curr] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(curr);
            while (!q.isEmpty()) {
                int node = q.remove();
                for (int el : graph[node]) {
                    if (color[el] == -1) {
                        color[el] = 1 - color[node];
                        q.add(el);
                    } else if (color[node] == color[el]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}