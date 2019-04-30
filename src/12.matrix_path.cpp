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
	bool hasPath(const char* matrix, int rows, int cols, const char* str) {
		if (matrix == nullptr || rows < 1 || cols < 1 || str == nullptr) return false;
		int matrix_len = rows * cols;
		int str_len = strlen(str);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// bool* visited = new bool[matrix_len];
				vector<bool> visited(matrix_len, false);
				if (find(matrix, i, j, rows, cols, str, 0, str_len, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	bool find(const char* matrix, int row_pos, int col_pos, int rows_num, int cols_num, const char* str, int ch_pos, int ch_len, vector<bool>& visited) {
		// 当前位置
		int cur = row_pos * cols_num + col_pos;
		if (visited[cur]) return false;
		// 当前位置元素和当前位置字符匹配
		if (matrix[cur] == str[ch_pos]) {
			// cout << "(" << row_pos << ", " << col_pos << ") :" << str[ch_pos] << endl;
			// 字符串被检索完
			if (++ch_pos >= ch_len) return true;
			visited[cur] = true;
			// 上下左右四个位置是否检索到路径
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
// ====================测试代码====================
void Test(const char* testName, const char* matrix, int rows, int cols, const char* str, bool expected) {
	if (testName != nullptr)
		printf("%s begins: ", testName);
	Solution s;
	
	if (s.hasPath(matrix, rows, cols, str) == expected)
		printf("Passed.\n");
	else
		printf("FAILED.\n");
}

//ABTG
//CFCS
//JDEH

//BFCE
void Test1() {
	const char* matrix = "ABTGCFCSJDEH";
	const char* str = "BFCE";

	Test("Test1", (const char*)matrix, 3, 4, str, true);
}

//ABCE
//SFCS
//ADEE

//SEE
void Test2() {
	const char* matrix = "ABCESFCSADEE";
	const char* str = "SEE";

	Test("Test2", (const char*)matrix, 3, 4, str, true);
}

//ABTG
//CFCS
//JDEH

//ABFB
void Test3() {
	const char* matrix = "ABTGCFCSJDEH";
	const char* str = "ABFB";

	Test("Test3", (const char*)matrix, 3, 4, str, false);
}

//ABCEHJIG
//SFCSLOPQ
//ADEEMNOE
//ADIDEJFM
//VCEIFGGS

//SLHECCEIDEJFGGFIE
void Test4() {
	const char* matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
	const char* str = "SLHECCEIDEJFGGFIE";

	Test("Test4", (const char*)matrix, 5, 8, str, true);
}

//ABCEHJIG
//SFCSLOPQ
//ADEEMNOE
//ADIDEJFM
//VCEIFGGS

//SGGFIECVAASABCEHJIGQEM
void Test5() {
	const char* matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
	const char* str = "SGGFIECVAASABCEHJIGQEM";

	Test("Test5", (const char*)matrix, 5, 8, str, true);
}

//ABCEHJIG
//SFCSLOPQ
//ADEEMNOE
//ADIDEJFM
//VCEIFGGS

//SGGFIECVAASABCEEJIGOEM
void Test6() {
	const char* matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
	const char* str = "SGGFIECVAASABCEEJIGOEM";

	Test("Test6", (const char*)matrix, 5, 8, str, false);
}

//ABCEHJIG
//SFCSLOPQ
//ADEEMNOE
//ADIDEJFM
//VCEIFGGS

//SGGFIECVAASABCEHJIGQEMS
void Test7() {
	const char* matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
	const char* str = "SGGFIECVAASABCEHJIGQEMS";

	Test("Test7", (const char*)matrix, 5, 8, str, false);
}

//AAAA
//AAAA
//AAAA

//AAAAAAAAAAAA
void Test8() {
	const char* matrix = "AAAAAAAAAAAA";
	const char* str = "AAAAAAAAAAAA";

	Test("Test8", (const char*)matrix, 3, 4, str, true);
}

//AAAA
//AAAA
//AAAA

//AAAAAAAAAAAAA
void Test9() {
	const char* matrix = "AAAAAAAAAAAA";
	const char* str = "AAAAAAAAAAAAA";

	Test("Test9", (const char*)matrix, 3, 4, str, false);
}

//A

//A
void Test10() {
	const char* matrix = "A";
	const char* str = "A";

	Test("Test10", (const char*)matrix, 1, 1, str, true);
}

//A

//B
void Test11() {
	const char* matrix = "A";
	const char* str = "B";

	Test("Test11", (const char*)matrix, 1, 1, str, false);
}

void Test12() {
	Test("Test12", nullptr, 0, 0, nullptr, false);
}

int main(int argc, char* argv[]) {
	Test1();
	Test2();
	Test3();
	Test4();
	Test5();
	Test6();
	Test7();
	Test8();
	Test9();
	Test10();
	Test11();
	Test12();

	return 0;
}

