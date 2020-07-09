package problem;

/**
* Title: 47. 礼物的最大价值
* Desc: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
* Created by Myth-PC on 15/02/2020 in VSCode
*/
public class P47MaxGift {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // m > 0, n > 0
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int i, j;
        for (i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }        
        for (i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}