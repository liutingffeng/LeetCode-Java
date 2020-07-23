package LCSolution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LC207 {

    class Solution {
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            int[] indegrees = new int[numCourses];
//
//            //初始化入度表
//            for (int[] prerequisite:prerequisites){
//                indegrees[prerequisite[0]]++;
//            }
//
//            Queue<Integer> queue = new ArrayDeque<>();
//            for (int i = 0; i < numCourses; i++) {
//                if (indegrees[i] == 0)
//                    queue.add(i);
//            }
//
//            while (!queue.isEmpty()){
//                int cur = queue.poll();
//                numCourses--;
//                for (int[] p:prerequisites){
//                    if (p[1] == cur){
//                        if (--indegrees[p[0]] == 0)
//                            queue.add(p[0]);
//                    }
//                }
//            }
//
//            return numCourses == 0;
//        }


        //DFS
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] flags = new int[numCourses];  // 0 未访问  ，1 正在访问 ， -1 已经被访问

            for (int i = 0; i < numCourses; i++) {
                if (!dfs(prerequisites,flags,i))
                    return false;
            }

            return true;
        }

        private boolean dfs(int[][] prerequisites,int[] flags,int i){
            if (flags[i] == 1)
                return false;
            if (flags[i] == -1)
                return true;

            flags[i] = 1;
            for (int[] p:prerequisites){
                if (p[1] == i){
                    if (!dfs(prerequisites, flags, p[0]))
                        return false;
                }
            }
            flags[i] = -1;
            return true;
        }
    }
}
