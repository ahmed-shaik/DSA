package Graphs.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int v, int[][] arr) {
            int[] indegree = new int[v];
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : arr) {
                int u = edge[1]; // prerequisite course
                int vCourse = edge[0]; // course that depends on the prerequisite
                adjList.get(u).add(vCourse);
                indegree[vCourse]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            int c = 0;
            while (!q.isEmpty()) {
                int node = q.remove();
                c++;
                for (int neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }

            return c == v;
        }
    }

}
