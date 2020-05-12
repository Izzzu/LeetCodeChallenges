package may;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean dp[][] = new boolean[image.length][image[0].length];
        if (sr>=image.length || sc >= image[0].length || sr<0 || sc <0) {
            return image;
        }
       return flood(image, sr, sc, newColor, dp, image[sr][sc]);
    }

    private int[][] flood(int[][] image, int sr, int sc, int newColor, boolean[][] dp, int oldColor) {

        if (sr>=image.length || sc >= image[0].length || sr<0 || sc <0 || dp[sr][sc] || image[sr][sc] != oldColor) {
            return image;
        }
        if (!dp[sr][sc]) {
            dp[sr][sc] = true;
            image[sr][sc] = newColor;
        }
        flood(image, sr-1, sc, newColor, dp, oldColor);

        flood(image, sr, sc-1, newColor, dp, oldColor);

        flood(image, sr+1, sc, newColor, dp, oldColor);

        flood(image, sr, sc+1, newColor, dp, oldColor);

        return image;
    }

    public static void main(String[] args) {
        int [][] arr = {{0,0,0},{0,1,1}};
        int[][] x = new FloodFill().floodFill(arr, 1, 1, 1);
        System.out.println(x);
    }
}
