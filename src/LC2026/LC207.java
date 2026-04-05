package LC2026;

import java.util.*;

public class LC207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 图关系
        Map<Integer, List<Integer>> adjList = new HashMap<>(numCourses);
        // 节点的度
        int[] degree = new int[numCourses];
        // 构建图
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            // [1, 0] 0 -> 1
            int preCourse = prerequisite[1];
            int nextCourse = prerequisite[0];
            adjList.get(preCourse).add(nextCourse);
            degree[nextCourse] += 1;
        }
        // 判断是否存在环，拓扑排序
        List<Integer> top = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            top.add(cur);
            for (int next : adjList.get(cur)) {
                degree[next] -= 1;
                if (degree[next] == 0) {
                    // 入队
                    queue.offer(next);
                }
            }
        }

        return top.size() == numCourses;
    }


}
