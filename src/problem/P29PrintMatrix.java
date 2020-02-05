package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 29. 顺时针打印矩阵
 * Desc: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * Created by Myth on 6/2/2019
 */
public class P29PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        // 控制四个边界
        int top = 0, right = matrix[0].length - 1, left = 0, bottom = matrix.length - 1;
        int i = 0, j = 0;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (top < bottom && left < right) {
            for (j = left; j < right; j++) {
                ret.add(matrix[i][j]);
            }
            for (i = top; i < bottom; i++) {
                ret.add(matrix[i][j]);
            }
            for (j = right; j > left; j--) {
                ret.add(matrix[i][j]);
            }
            for (i = bottom; i > top; i--) {
                ret.add(matrix[i][j]);
            }
            top++;
            bottom--;
            left++;
            right--;
            i = top;
            j = left;
        }
        if (top == bottom && left == right) {
            ret.add(matrix[top][left]);
        } else {
            if (top == bottom) {
                for (j = left; j <= right; j++) {
                    ret.add(matrix[top][j]);
                }
            }
            if (left == right) {
                for (i = top; i <= bottom; i++) {
                    ret.add(matrix[i][left]);
                }
            }
        }
        return ret;
    }
    // 不使用visited数组，设置边界
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return ret;
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1; 
        int i, j;
        while (left <= right && top <= bottom) {
            for (j = left; j <= right; j++) ret.add(matrix[top][j]);
            top++;
            if (top > bottom) break;
            for (i = top; i <= bottom; i++) ret.add(matrix[i][right]);
            right--;
            if (right < left) break;
            for (j = right; j >= left; j--) ret.add(matrix[bottom][j]);
            bottom--;
            if (top > bottom) break;
            for (i = bottom; i >= top; i--) ret.add(matrix[i][left]);
            left++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix4 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11},{13, 14, 15}};
        int[][] matrix5 = {{1}, {2}, {3},{4},{5}};
        int[][] matrix6 = {{1, 2, 3, 4, 5}};
        ArrayList<Integer> ret2 = P29PrintMatrix.printMatrix(matrix2);
        ArrayList<Integer> ret5 = P29PrintMatrix.printMatrix(matrix5);
        System.out.println(ret2.toString());
        System.out.println(ret5.toString());
    }
}
