#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct ListNode {
	int var;
	ListNode* next;
};
class Solution {
public:
	vector<int> printListFromTailToHead(ListNode* head) {
		vector<int> v;
		if (head == nullptr) {
			return v;
		}
		ListNode* p = head->next;
		while (p) {
			v.push_back(p->var);
			p = p->next;
		}
		reverse(v.begin(), v.end());
		return v;
	}
};
// 控制台输入构建链表
ListNode* create() {
	ListNode* head = new ListNode;
	ListNode* tail = head; // 需要一个尾指针进行封尾操作
	ListNode* p = new ListNode;
	head->var = 0; // 头指针不存东西
	head->next = p;
	// 0个元素时
	while (cin >> p->var) {
		p->next = new ListNode;
		tail = p;
		p = p->next;
	}
	tail->next = NULL;
	delete p;
	p = NULL;

	return head;
}
// void show(ListNode*& head)
void show(ListNode* head) {
	if (head == nullptr) {
		cout << "空链表" << endl;
		return;
	}
	// ListNode* p = head->next; // 跳过头指针
	// 此处使用head，依然不会改变head（指针）的值，head是个形参指针，如果加上引用那么就会改变其值
	head = head->next;
	while (head) {
		cout << head->var << " ";
		head = head->next;
	}
	cout << endl;
}
int main() {
	ListNode* head = create();
	cout << head << endl;
	show(head);
	cout << head << endl;
	Solution s;
	vector<int> v;
	v = s.printListFromTailToHead(head);
	for (vector<int>::iterator i = v.begin(); i != v.end(); i++) {
		cout << *i << endl;
	}
}