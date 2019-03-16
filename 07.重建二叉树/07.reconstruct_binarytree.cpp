#include<iostream>
#include<vector>
#include<string>
using namespace std;
void printVector(string s, vector<int> v);
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
class Solution {
public:
	// 递归
	TreeNode* reConstructBinaryTree(vector<int> pre, vector<int> vin) {
		TreeNode* root = NULL;
		if (pre.size() >= 1) {
			root = new TreeNode(pre[0]);
			cout << "Root" << root->val << endl;
			// 左半枝
			vector<int> left_branch;
			int j;
			for (j = 0; j < vin.size(); j++) {
				if (vin[j] == pre[0]) break;
				left_branch.push_back(vin[j]);
			}
			// 右半枝
			vector<int> right_branch;
			for (j = j + 1; j < vin.size(); j++) {
				right_branch.push_back(vin[j]);
			}
			// 注意新的pre的范围（第一次写时，出错了）
			// 第一次错误代码：vector<int> pre(pre.begin() + 1, pre.end());
			vector<int> left_pre(pre.begin() + 1, pre.begin() + 1 + left_branch.size());
			vector<int> right_pre(pre.begin() + 1 + left_branch.size(), pre.end());
			// printVector(new_pre);
			printVector("左边：", left_branch);
			printVector("右边：", right_branch);
			root->left = reConstructBinaryTree(left_pre, left_branch);
			root->right = reConstructBinaryTree(right_pre, right_branch);
		}
		return root;
	}
};
// 前序遍历
void preShow(TreeNode* root) {
	if (root == nullptr) return;
	cout << root->val << " ";
	preShow(root->left);
	preShow(root->right);
}
// 遍历vector
void printVector(string des, vector<int> v) {
	cout << des << ": ";
	for (vector<int>::iterator i = v.begin(); i != v.end(); i++) {
		cout << *i << " ";
	}
	cout << endl;
}
/* 
思路：
	根据前序和中序的特点，将树划分分为左右子树，递归构建
	其中如何划分是重点
*/
int main() {
	vector<int> pre = { 1,2,4,7,3,5,6,8 };
	vector<int> vin = { 4,7,2,1,5,3,8,6 };
	// vector<int> pre = { 1,2,3};
	// vector<int> vin = { 2,1,3};
	Solution s;
	TreeNode* root = s.reConstructBinaryTree(pre, vin);
	preShow(root);
}