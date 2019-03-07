#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	// n+1 长度的数组在 1 —— n 范围内，一定存在重复数字，找出任意一个重复数字，不能修改数组！
	int duplicate(int numbers[], int length) {
		if (length < 1) {
			return -1;
		}
		if (length == 1) {
			return 1;
		}
		int start = 1;
		int end = length - 1;
		int mid;
		int num;
		while (start < end) {
			mid = (end + start) / 2;
			cout << start << "---" << mid << "---"<< end << endl;
			num = count_num(start, mid, numbers, length);
			if (num > mid - start + 1) {
				if (mid == start) {
					return start;
				} else {
					end = mid;	
				}
			} else {
				start = mid;
			}
		}
		return -1;
	}

	int count_num(int start, int end, int numbers[], int length) {
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
	int numbers[] = { 2, 3, 5, 4, 6, 2, 6, 7};
	cout << s.duplicate(numbers, 8);


}