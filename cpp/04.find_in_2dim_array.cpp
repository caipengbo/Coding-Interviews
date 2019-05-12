#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
	// 思路1：遍历、二分查找
	bool Find(int target, vector<vector<int>> array) {
		bool is_find = false;
		for (vector<vector<int>>::iterator it = array.begin(); it != array.end(); it++) {
			is_find = binary_search((*it).begin(), (*it).end(), target);
			if (is_find) return true;
		}
		return is_find;
	}
	//如果从左上角开始的话，碰见比target大的数的话，会有**两个方向**检索，要么往下，要么往右。
	//那么就从右上角（或者左下角，思路类似）开始查找，如果小于target，(如果存在)肯定在此列；如果大于target，肯定不会在此列，舍弃此列，往左重复以上步骤查找。
	bool Find2(int target, vector<vector<int>> array) {
		for (vector<vector<int>>::reverse_iterator it = array.rbegin(); it != array.rend(); it++) {
			if ((*it)[0] == target) {
				return true;
			} else if ((*it)[0] > target) {
				continue;
			} else if ((*it)[0] < target){
				return binary_search((*it).begin(), (*it).end(), target);
			}
		}
		return false;
	}
};

int main()
{
	vector<vector<int>> array = { {1, 2, 3}, {11, 12, 13}, {21, 22, 23} };
	Solution s;
	cout << s.Find2(21, array);
}