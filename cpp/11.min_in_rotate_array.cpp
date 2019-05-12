#include<iostream>
#include<vector>
using namespace std;
// LeetCode 154. Find Minimum in Rotated Sorted Array II
// 剑指offer 11题
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
            // 存在相等的情况
            // 测试用例 1,0,1,1,1
            // 10, 1, 10, 10, 10
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                return sequenceSearch(nums, left, right);
                // 等于号也不要忘记
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
    // 最简单的实现
    int minNumberInRotateArray2(vector<int> nums) {
        int n = nums.size();
        if (n == 0) return -1;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {  // mid —— right 之间
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // left —— mid 之间
                right = mid;
            } else {
                // 有重复的时候, 不确定在哪一边,但是 right 肯定不是，所以缩短检索范围
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