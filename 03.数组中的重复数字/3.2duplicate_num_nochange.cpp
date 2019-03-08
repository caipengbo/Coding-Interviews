#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	// n+1 长度的数组在 1 —— n 范围内，一定存在重复数字，找出任意一个重复数字，不能修改数组！
	int duplicate(int numbers[], int length) {
		if (numbers == nullptr || length <= 0) {
			return -1;
		}
		int start = 1;
		int end = length - 1;
		int mid;
		int count;
		while (start <= end) {
			mid = (end + start) / 2;
			count = count_num(start, mid, numbers, length);
			if (count > mid - start + 1) {
				end = mid - 1 ;
			} else {
				start = mid + 1;
			}
			cout << start << "---" << mid << "---" << end << endl;
		}
		return mid;
	}

	int count_num(int start, int end, int numbers[], int length) {
		if (numbers == nullptr) {
			return 0;
		}
		int num = 0;
		for (int i = 0; i < length; i++) {
			if (numbers[i] >= start && numbers[i] <= end)
				num++;
		}
		return num;
	}
};
int main() 
{
	Solution s;
	int numbers[] = { 1, 3, 2, 4, 5, 7, 6, 7};
	cout << s.duplicate(numbers, 8);
}