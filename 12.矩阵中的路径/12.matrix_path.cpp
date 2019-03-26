#include "pch.h"
/**
 * Title: 矩阵中的路径
 * Desc: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *		路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *		如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *		例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 *		但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * Author: Myth
 */
class Solution {
public:
	bool hasPath(char* matrix, int rows, int cols, char* str) {
		if (matrix == nullptr || rows < 1 || cols < 1 || str == nullptr) return false;
		int matrix_len = rows * cols;
		int str_len = strlen(str);
		vector<bool> visited(matrix_len, false);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// bool* visited = new bool[matrix_len];
				if (find(matrix, i, j, rows, cols, str, 0, str_len, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	bool find(char* matrix, int row_pos, int col_pos, int rows_num, int cols_num, char* str, int ch_pos, int ch_len, vector<bool> visited) {
		// 当前位置
		int cur = row_pos * cols_num + col_pos;
		if (visited[cur]) return false;
		if (matrix[cur] == str[ch_pos]) {
			cout << "(" << row_pos << ", " << col_pos << ") :" << str[ch_pos] << endl;
			if (++ch_pos >= ch_len) return true;
			visited[cur] = true;
			bool found1 = false, found2 = false, found3 = false, found4 = false;
			// 上
			if (row_pos - 1 >= 0) {
				found1 = find(matrix, row_pos - 1, col_pos, rows_num, cols_num, str, ch_pos, ch_len, visited);
			}
			// 下
			if (row_pos + 1 < rows_num) {
				found2 = find(matrix, row_pos + 1, col_pos, rows_num, cols_num, str, ch_pos, ch_len, visited);
			}
			// 左
			if (col_pos - 1 >= 0) {
				found3 = find(matrix, row_pos, col_pos - 1, rows_num, cols_num, str, ch_pos, ch_len, visited);
			}
			// 右
			if (col_pos + 1 < cols_num) {
				found4 = find(matrix, row_pos, col_pos + 1, rows_num, cols_num, str, ch_pos, ch_len, visited);
			}
			return (found1 || found2 || found3 || found4);
		}
		return false;
	}
};
int main()
{
	Solution s;
	char matrix[] = "abtgcfcsjdeh";
	char str[] = "abfb";
	cout << s.hasPath(matrix, 3, 4, str);

}

