#include "pch.h"
/**
 * Title: 机器人的运动范围
 * Desc: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子?
 * 重点：本题因为使用了值传参，没使用引用传参，出了bug，浪费了很长的时间
 * Author: Myth
 */
class Solution {
public:
	int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows <=0 || cols <= 0) {
			return 0;
		}
		vector<bool> visited(rows * cols, false);
		return detect(0, 0, threshold, rows, cols, visited);

		/*if (threshold < 0 || rows <= 0 || cols <= 0)
			return 0;

		bool *visited = new bool[rows * cols];
		for (int i = 0; i < rows * cols; ++i)
			visited[i] = false;

		int count = detect2(0, 0, threshold, rows, cols, visited);

		delete[] visited;

		return count;*/

	}
	int detect(int row, int col, int threshold, int rows, int cols, vector<bool>& visited) {
		int cur = row * cols + col;
		if (visited[cur]) return 0;
		int count = 0;
		
		if (sumOfEveryLocation(row) + sumOfEveryLocation(col) <= threshold) {
			visited[cur] = true;
			int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
			if (row - 1 >= 0) {
				count1 = detect(row - 1, col, threshold, rows, cols, visited);
			}
			if (row + 1 < rows) {
				count2 = detect(row + 1, col, threshold, rows, cols, visited);
			}
			if (col - 1 >= 0) {
				count3 = detect(row, col - 1, threshold, rows, cols, visited);
			}
			if (col + 1 < cols) {
				count4 = detect(row, col + 1, threshold, rows, cols, visited);
			}
			count = 1 + count1 + count2 + count3 + count4;
		}

		return count;
	}
	int sumOfEveryLocation(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		// cout << "(" << number << ")";
		return sum;
	}
	// 使用这种写法更清晰
	int detect2(int row, int col, int threshold, int rows, int cols, bool *visited) {
		int count = 0;
		// cout << "(" << row << "," << col << ")";
		if (check(row, col, threshold, rows, cols, visited)) {
			visited[row*cols+col] = true;

			count = 1 + detect2(row - 1, col, threshold, rows, cols, visited)
				+ detect2(row + 1, col, threshold, rows, cols, visited) + 
				detect2(row, col - 1, threshold, rows, cols, visited)
				+ detect2(row, col + 1, threshold, rows, cols, visited);
		}
		return count;
	}

	bool check(int row, int col, int threshold, int rows, int cols, bool *visited) {
		if (row >= 0 && col >= 0 && row < rows && col < cols && sumOfEveryLocation(row) + sumOfEveryLocation(col) <= threshold
			&& !visited[row * cols + col]) {
			return true;
		}
		return false;
	}
};
class Solution2 {
public:
	int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows <= 0 || cols <= 0)
			return 0;

		bool *visited = new bool[rows * cols];
		for (int i = 0; i < rows * cols; ++i)
			visited[i] = false;

		int count = movingCountCore(threshold, rows, cols,
			0, 0, visited);

		delete[] visited;

		return count;
	}

	int movingCountCore(int threshold, int rows, int cols, int row,
		int col, bool* visited) {
		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;

			count = 1 + movingCountCore(threshold, rows, cols,
				row - 1, col, visited)
				+ movingCountCore(threshold, rows, cols,
					row, col - 1, visited)
				+ movingCountCore(threshold, rows, cols,
					row + 1, col, visited)
				+ movingCountCore(threshold, rows, cols,
					row, col + 1, visited);
		}

		return count;
	}

	bool check(int threshold, int rows, int cols, int row, int col,
		bool* visited) {
		if (row >= 0 && row < rows && col >= 0 && col < cols
			&& getDigitSum(row) + getDigitSum(col) <= threshold
			&& !visited[row* cols + col])
			return true;

		return false;
	}

	int getDigitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}
};

// ====================测试代码====================
void test(string testName, int threshold, int rows, int cols, int expected) {
	if (testName.size() != 0)
		cout << testName << ": ";

	Solution s;
	int ret = s.movingCount(threshold, rows, cols);
	cout << "Result:" << ret;
	if (ret == expected)
		printf("Passed.\n");
	else
		printf("FAILED.\n");
}

// 方格多行多列
void test1() {
	test("Test1", 5, 10, 10, 21);
}

// 方格多行多列
void test2() {
	test("Test2", 15, 20, 20, 359);
}

// 方格只有一行，机器人只能到达部分方格
void test3() {
	test("Test3", 10, 1, 100, 29);
}

// 方格只有一行，机器人能到达所有方格
void test4() {
	test("Test4", 10, 1, 10, 10);
}

// 方格只有一列，机器人只能到达部分方格
void test5() {
	test("Test5", 15, 100, 1, 79);
}

// 方格只有一列，机器人能到达所有方格
void test6() {
	test("Test6", 15, 10, 1, 10);
}

// 方格只有一行一列
void test7() {
	test("Test7", 15, 1, 1, 1);
}

// 方格只有一行一列
void test8() {
	test("Test8", 0, 1, 1, 1);
}

// 机器人不能进入任意一个方格
void test9() {
	test("Test9", -10, 10, 10, 0);
}

int main() {
	test1();
	test2();
	test3();
	test4();
	test5();
	test6();
	test7();
	test8();
	test9();

	return 0;
}
