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
// ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
// ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
class Solution {
public:
	// �ݹ�
	TreeNode* reConstructBinaryTree(vector<int> pre, vector<int> vin) {
		TreeNode* root = NULL;
		if (pre.size() >= 1) {
			root = new TreeNode(pre[0]);
			cout << "Root" << root->val << endl;
			// ���֦
			vector<int> left_branch;
			int j;
			for (j = 0; j < vin.size(); j++) {
				if (vin[j] == pre[0]) break;
				left_branch.push_back(vin[j]);
			}
			// �Ұ�֦
			vector<int> right_branch;
			for (j = j + 1; j < vin.size(); j++) {
				right_branch.push_back(vin[j]);
			}
			// ע���µ�pre�ķ�Χ����һ��дʱ�������ˣ�
			// ��һ�δ�����룺vector<int> pre(pre.begin() + 1, pre.end());
			vector<int> left_pre(pre.begin() + 1, pre.begin() + 1 + left_branch.size());
			vector<int> right_pre(pre.begin() + 1 + left_branch.size(), pre.end());
			// printVector(new_pre);
			printVector("��ߣ�", left_branch);
			printVector("�ұߣ�", right_branch);
			root->left = reConstructBinaryTree(left_pre, left_branch);
			root->right = reConstructBinaryTree(right_pre, right_branch);
		}
		return root;
	}
};
// ǰ�����
void preShow(TreeNode* root) {
	if (root == nullptr) return;
	cout << root->val << " ";
	preShow(root->left);
	preShow(root->right);
}
// ����vector
void printVector(string des, vector<int> v) {
	cout << des << ": ";
	for (vector<int>::iterator i = v.begin(); i != v.end(); i++) {
		cout << *i << " ";
	}
	cout << endl;
}
/* 
˼·��
	����ǰ���������ص㣬�������ַ�Ϊ�����������ݹ鹹��
	������λ������ص�
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