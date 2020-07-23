package LCSolution;

import java.util.*;

public class LC051 {

    class Solution {
        //列
        private boolean[] col;
        //对角
        private boolean[] dia1;
        private boolean[] dia2;
        private ArrayList<List<String>> res;
        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<List<String>>();
            col = new boolean[n];
            dia1 = new boolean[2 * n - 1];
            dia2 = new boolean[2 * n - 1];

            putQueue(n, 0, new ArrayList<>());
            return res;
        }

        private void putQueue(int n,int index,List<Integer> temp){
            if (index == n){
                res.add(convert(temp, n));
                return;
            }

            //[index,i]
            for (int i=0;i<n;i++){
                if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                    col[i] = true;
                    dia1[index+i] = true;
                    dia2[index-i+n-1] = true;
                    temp.add(i);
                    putQueue(n, index+1,  temp);
                    temp.remove(temp.size()-1);
                    col[i] = false;
                    dia1[index+i] = false;
                    dia2[index-i+n-1] = false;
                }
            }
        }

        private List<String> convert(List<Integer> temp,int n){
            List<String> res = new ArrayList<>();
            for (int i=0;i<temp.size();i++){
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[temp.get(i)] = 'Q';
                res.add(new String(charArray));
            }
            return res;
        }


        // 尝试将第index行的皇后摆放在第i列
    }
}
