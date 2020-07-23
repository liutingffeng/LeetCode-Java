package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC200 {

    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return count;
            int m = grid.length;
            int n = grid[0].length;
            for (int i=0;i<m;i++)
                for (int j=0;j<n;j++){
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid,i,j,m,n);
                    }
                }
            return count;
        }

        public void dfs(char[][] grid,int i,int j,int m,int n){
            if (i<0 || i>=m || j<0 || j>=n)
                return;
            if (grid[i][j]=='0')
                return;

            grid[i][j] = '0';
            dfs(grid, i, j+1, m, n);
            dfs(grid, i, j-1, m, n);
            dfs(grid, i+1, j, m, n);
            dfs(grid, i-1, j, m, n);
        }
    }
}
