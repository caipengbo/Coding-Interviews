package problem;

/**
* Title: 12. 矩阵中的路径
* Desc: 
* Created by Myth-PC on 29/01/2020 in VSCode
*/
public class P12MatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int n = rows * cols;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (backtrack(matrix, rows, cols, i, str, 0, visited)) return true;
        }
        return false;
    }
    // i: matrix位置    cur: str中的位置
    private boolean backtrackError(char[] matrix, int rows, int cols, int i, char[] str, int cur, boolean[] visited) {
        if (cur >= str.length) return true;  // 匹配成功
        if (i >= rows*cols || i < 0 || visited[i] || matrix[i] != str[cur]) return false;  // 失败
        // 上
        boolean top = false, bottom = false, left = false, right = false;
        visited[i] = true;
        // 此处和20行的判断条件重复，是为了避免多一次递归，但是会导致最后一次无法判断cur
        if (i-cols >= 0 && !visited[i-cols]) top = backtrack(matrix, rows, cols, i-cols, str, cur+1, visited);
        if (i+cols < rows*cols && !visited[i+cols]) bottom = backtrack(matrix, rows, cols, i+cols, str, cur+1, visited);
        if (i%cols != 0 && !visited[i-1]) left = backtrack(matrix, rows, cols, i-1, str, cur+1, visited);
        if ((i+1)%cols != 0 && !visited[i+1]) right = backtrack(matrix, rows, cols, i+1, str, cur+1, visited);
        visited[i] = false;
        return (top || bottom || left || right);
    }
    private boolean backtrack(char[] matrix, int rows, int cols, int i, char[] str, int cur, boolean[] visited) {
        if (cur >= str.length) return true;  // 匹配成功
        if (i >= rows*cols || i < 0 || visited[i] || matrix[i] != str[cur]) return false;  // 失败
        boolean top = false, bottom = false, left = false, right = false;
        visited[i] = true;
        // 此处和20行的判断条件重复，是为了避免多一次递归，但是会导致最后一次无法判断cur
        if (cur+1 >= str.length || (i-cols >= 0 && !visited[i-cols])) top = backtrack(matrix, rows, cols, i-cols, str, cur+1, visited);
        if (cur+1 >= str.length || (i+cols < rows*cols && !visited[i+cols])) bottom = backtrack(matrix, rows, cols, i+cols, str, cur+1, visited);
        if (cur+1 >= str.length || (i%cols != 0 && !visited[i-1])) left = backtrack(matrix, rows, cols, i-1, str, cur+1, visited);
        if (cur+1 >= str.length || ((i+1)%cols != 0 && !visited[i+1])) right = backtrack(matrix, rows, cols, i+1, str, cur+1, visited);
        visited[i] = false;
        return (top || bottom || left || right);
    }
    // 选择此种写法！！！
    private boolean backtrack2(char[] matrix, int rows, int cols, int i, char[] str, int cur, boolean[] visited) {
        if (cur >= str.length) return true;  // 匹配成功
        if (i >= rows*cols || i < 0 || visited[i] || matrix[i] != str[cur]) return false;  // 失败
        // 上
        boolean top = false, bottom = false, left = false, right = false;
        visited[i] = true;
        top = backtrack(matrix, rows, cols, i-cols, str, cur+1, visited);
        bottom = backtrack(matrix, rows, cols, i+cols, str, cur+1, visited);
        left = backtrack(matrix, rows, cols, i-1, str, cur+1, visited);
        right = backtrack(matrix, rows, cols, i+1, str, cur+1, visited);
        visited[i] = false;
        return (top || bottom || left || right);
    }
    public static void main(String[] args) {
        P12MatrixPath p12 = new P12MatrixPath();
        System.out.println(p12.hasPath("AAA".toCharArray(), 3, 1, "AAA".toCharArray()));
    }
}