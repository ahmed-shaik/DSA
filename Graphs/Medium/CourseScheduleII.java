package Graphs.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    class Solution {
        public int[] findOrder(int v, int[][] arr) {
            int[] indegree = new int[v];
            List<List<Integer>> adjList = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : arr) {
                int u = edge[1]; // prerequisite course
                int vCourse = edge[0]; // course depending on the prerequisite
                adjList.get(u).add(vCourse);
                indegree[vCourse]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            int[] topo = new int[v];
            int index = 0;

            // Kahn's Algorithm for Topological Sort (BFS)
            while (!q.isEmpty()) {
                int node = q.poll();
                topo[index++] = node;
                for (int neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
            if (index != v) {
                return new int[0];
            }

            return topo;
        }
    }

}
