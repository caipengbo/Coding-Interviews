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
// ����̨���빹������
ListNode* create() {
	ListNode* head = new ListNode;
	ListNode* tail = head; // ��Ҫһ��βָ����з�β����
	ListNode* p = new ListNode;
	head->var = 0; // ͷָ�벻�涫��
	head->next = p;
	// 0��Ԫ��ʱ
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
		cout << "������" << endl;
		return;
	}
	// ListNode* p = head->next; // ����ͷָ��
	// �˴�ʹ��head����Ȼ����ı�head��ָ�룩��ֵ��head�Ǹ��β�ָ�룬�������������ô�ͻ�ı���ֵ
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