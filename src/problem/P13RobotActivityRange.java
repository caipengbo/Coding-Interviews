package problem;

/**
* Title: 13. 机器人的运动范围
* Desc: (0,0) 开始 移动，能到达多少个格子 各位和 <= threshold
* Created by Myth-PC on 30/01/2020 in VSCode
*/
public class P13RobotActivityRange {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited);
    }
    public int dfs(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return 0;
        visited[i][j] = true;
        if (digitSum(i) + digitSum(j) > threshold) return 0;
        int count = 1;
        count += dfs(threshold, rows, cols, i-1, j, visited);
        count += dfs(threshold, rows, cols, i+1, j, visited);
        count += dfs(threshold, rows, cols, i, j-1, visited);
        count += dfs(threshold, rows, cols, i, j+1, visited);
        return count;
    }
    private int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}