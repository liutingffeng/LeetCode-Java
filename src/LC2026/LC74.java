package LC2026;

public class LC74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        while (i < row && matrix[i][0] <= target) {
            if (matrix[i][col - 1] < target) {
                i++;
            } else {
                int k = 0, j = col - 1;
                while (k <= j) {
                    int mid = k + (j - k) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    if (matrix[i][mid] < target) {
                        k = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

}
