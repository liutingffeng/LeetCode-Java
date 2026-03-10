package LC2026;

public class LC036 {

    public boolean isValidSudoku(char[][] board) {
        // 检查每一行
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        // 检查每一列
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        // 检查每个 3x3 宫格
        for (int block = 0; block < 9; block++) {
            boolean[] seen = new boolean[9];
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (seen[num]) return false;
                        seen[num] = true;
                    }
                }
            }
        }

        return true;
    }


}
