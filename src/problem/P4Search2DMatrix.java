package problem;

/**
* Title: 4. 搜索二维矩阵
* Desc: 每一行有序，每一列有序
* Created by Myth-PC on 26/01/2020 in VSCode
*/
public class P4Search2DMatrix {
    // 双指针，缩减空间 搜索
    // 左下角 右上角开始减少移动范围
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length, row = 0, col = n-1;
        while (row < m && col >= 0) {
            if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
            else return true;
        }
        return false;
    }
}