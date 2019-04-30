#include<iostream>
using namespace std;
class Solution {
public:
	// 题目请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	// length 会 大于最终的字符串长度（有足够的内存）
	void replaceSpace(char *str, int length) {
		if (str == nullptr || length <= 0) {
			return;
		}
		int old_length = 0;
		int space_count = 0;
		int new_length = 0;
		// 遍历，统计空格数目
		while (str[old_length] != '\0') {
			if (str[old_length] == ' ') {
				space_count++;
			}
			old_length++;
		}
		new_length = space_count * 2 + old_length;
		if (new_length > length) return;
		// 移动字符时的指针（索引）
		int tail = new_length - 1;
		
		str[new_length] = '\0';
		for (int i = old_length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				str[tail--] = str[i];
			} else {
				str[tail--] = '0';
				str[tail--] = '2';
				str[tail--] = '%';
			}
		}
	}
};
/*
思路： 
	从后往前进行替换
总结：
	如果从前往后需要重复移动（操作）多次时候，试着从后往前进行，看看是否减少了次数
*/
int main() 
{
	char str[100] = " ";
	Solution s;
	s.replaceSpace(str, 100);
	cout << str << endl;
}
