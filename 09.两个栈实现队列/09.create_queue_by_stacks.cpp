#include<iostream>
#include<stack>
using namespace std;
class Solution {
public:
	// 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	void push(int node) {
		stack1.push(node);
	}
	// 方法1：像两个杯子一样，倒过来，又倒过去
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
	// 方法2：stack1用来push，stack2 用来pop
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