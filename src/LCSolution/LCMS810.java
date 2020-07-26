package LCSolution;

public class LCMS810 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        dfs(image, sr, sc, newColor,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor,int originColor){
        if (sr<0 || sr>=image.length || sc<0 || sc>=image[0].length)
            return;

        if (image[sr][sc]!=originColor){
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, newColor,originColor);
        dfs(image, sr+1, sc, newColor,originColor);
        dfs(image, sr, sc+1, newColor,originColor);
        dfs(image, sr, sc-1, newColor,originColor);
    }
}
