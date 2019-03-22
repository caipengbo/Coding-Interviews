#include<iostream>
#include<vector>
using namespace std;
// LeetCode 154. Find Minimum in Rotated Sorted Array II
// ��ָoffer 11��
class Solution {
public:
	int minNumberInRotateArray(vector<int> nums) {
		int n = nums.size();
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		if (nums[left] < nums[right]) return nums[left];
		
		while (left+1 < right) {
			int mid = (left + right) / 2;
			// ������ȵ����
			// �������� 1,0,1,1,1
			// 10, 1, 10, 10, 10
			if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
				return sequenceSearch(nums, left, right);
			// ���ں�Ҳ��Ҫ����
			}else if (nums[mid] >= nums[left]) {
				left = mid;
			} else if (nums[mid] <= nums[right]) {
				right = mid;
			}
		}
		return nums[right];
	}
	int sequenceSearch(vector<int> rotateArray, int left, int right) {
		int rtn = rotateArray[left];
		for (int i = left; i + 1 < right; i++) {
			if (rotateArray[i] > rotateArray[i+1]) {
				rtn = rotateArray[i + 1];
				break;
			}
		}
		return rtn;
	}
	// ��򵥵�ʵ��
	int minNumberInRotateArray2(vector<int> nums) {
		int n = nums.size();
		if (n == 0) return -1;
		
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {  // mid ���� right ֮��
				left = mid + 1;
			} else if (nums[mid] < nums[right]) { // left ���� mid ֮��
				right = mid;
			} else {
				// ���ظ���ʱ��, ��ȷ������һ��,���� right �϶����ǣ��������̼�����Χ
				right--;
			}
		}
		return nums[left];
	}
};
int main() {
	vector<int> vec = { 3, 1, 3};
	Solution s;
	cout << s.minNumberInRotateArray2(vec) << endl;
}