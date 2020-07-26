package LCSolution;

import java.util.*;

public class LC773 {

    class Solution {
        public int slidingPuzzle(int[][] board) {
            Set<String> set = new HashSet<>();
            Deque<String> q = new ArrayDeque<>();
            String temp;
            String target = "123450";

            //构建temp;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(board[i][j]);
                }
            }

            temp = sb.toString();
            if (temp.equals(target))
                return 0;
            int step = 0;
            q.addLast(temp);
            set.add(temp);
            while (!q.isEmpty()){
                step++;
                int size = q.size();

                while (size -- >0){
                    String cur = q.pollFirst();
                    int pos0 =0;

                    for (int i = 0; i < 6; i++) {
                        pos0 = i;
                        if (cur.charAt(i) == '0')
                            break;
                    }

                    // 与左边交换
                    if (pos0==1 || pos0 == 2 || pos0 == 4 || pos0 == 5){
                        String next = swapStr(cur, pos0, pos0-1);
                        if (next.equals(target))
                            return step;
                        if (!set.contains(next)){
                            q.addLast(next);
                            set.add(next);
                        }
                    }

                    //与右边交换
                    if (pos0==0 || pos0 == 1 || pos0 == 3 || pos0 == 4){
                        String next = swapStr(cur, pos0, pos0+1);
                        if (next.equals(target))
                            return step;
                        if (!set.contains(next)){
                            q.addLast(next);
                            set.add(next);
                        }
                    }

                    //上下
                    int nexPos = pos0<3 ? pos0+3:pos0-3;
                    String next = swapStr(cur, pos0, nexPos);
                    if (next.equals(target))
                        return step;
                    if (!set.contains(next)){
                        q.addLast(next);
                        set.add(next);
                    }
                }
            }
            return -1;
        }

        private String swapStr(String s,int i,int j){
            char[] charArray = s.toCharArray();
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            return new String(charArray);
        }
    }

    public static void main(String[] args) {
        new LC773().new Solution().slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
    }
}
