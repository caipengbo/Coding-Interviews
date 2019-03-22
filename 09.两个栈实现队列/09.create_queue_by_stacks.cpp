#include<iostream>
#include<stack>
using namespace std;
class Solution {
public:
	// ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
	void push(int node) {
		stack1.push(node);
	}
	// ����1������������һ�������������ֵ���ȥ
	int pop() {
		if (stack1.empty()) return -1;
		int rtn;
		while (!stack1.empty()) {
			int val = stack1.top();
			stack1.pop();
			stack2.push(val);
		}
		rtn = stack2.top();
		stack2.pop();
		while (!stack2.empty()) {
			int val = stack2.top();
			stack2.pop();
			stack1.push(val);
		}
		return rtn;
	}
	// ����2��stack1����push��stack2 ����pop
	int pop2() {
		if (stack1.empty() && stack2.empty()) return -1;
		int rtn;
		if (!stack2.empty()) {
			rtn = stack2.top();
			stack2.pop();	
		} else {
			while (!stack1.empty()) {
				int val = stack1.top();
				stack1.pop();
				stack2.push(val);
			}
			rtn = stack2.top();
			stack2.pop();
		}
		return rtn;
	}
private:
	stack<int> stack1;
	stack<int> stack2;
};