#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
	// ˼·1�����������ֲ���
	bool Find(int target, vector<vector<int>> array) {
		bool is_find = false;
		for (vector<vector<int>>::iterator it = array.begin(); it != array.end(); it++) {
			is_find = binary_search((*it).begin(), (*it).end(), target);
			if (is_find) return true;
		}
		return is_find;
	}
	//��������Ͻǿ�ʼ�Ļ���������target������Ļ�������**��������**������Ҫô���£�Ҫô���ҡ�
	//��ô�ʹ����Ͻǣ��������½ǣ�˼·���ƣ���ʼ���ң����С��target��(�������)�϶��ڴ��У��������target���϶������ڴ��У��������У������ظ����ϲ�����ҡ�
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