#include<iostream>
using namespace std;
class Solution {
public:
	// ��Ŀ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
	// length �� �������յ��ַ������ȣ����㹻���ڴ棩
	void replaceSpace(char *str, int length) {
		if (str == nullptr || length <= 0) {
			return;
		}
		int old_length = 0;
		int space_count = 0;
		int new_length = 0;
		// ������ͳ�ƿո���Ŀ
		while (str[old_length] != '\0') {
			if (str[old_length] == ' ') {
				space_count++;
			}
			old_length++;
		}
		new_length = space_count * 2 + old_length;
		if (new_length > length) return;
		// �ƶ��ַ�ʱ��ָ�루������
		int tail = new_length - 1;
		
		str[new_length] = '\0';
		for (int i = old_length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				str[tail--] = str[i];
			} else {
				str[tail--] = '0';
				str[tail--] = '2';
				str[tail--] = '%';
			}
		}
	}
};
/*
˼·�� 
	�Ӻ���ǰ�����滻
�ܽ᣺
	�����ǰ������Ҫ�ظ��ƶ������������ʱ�����ŴӺ���ǰ���У������Ƿ�����˴���
*/
int main() 
{
	char str[100] = " ";
	Solution s;
	s.replaceSpace(str, 100);
	cout << str << endl;
}
