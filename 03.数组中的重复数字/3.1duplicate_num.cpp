#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	// Parameters:
	//        numbers:     an array of integers
	//        length:      the length of array numbers
	//        duplication: (Output) the duplicated number in the array number（任意一个重复的数）
	// Return value:       true if the input is valid, and there are some duplications in the array number
	//                     otherwise false
	bool duplicate(int numbers[], int length, int* duplication) {
		if (numbers == nullptr) return false;

		for (int j = 0; j < length; j++) {
			if (numbers[j] >= length || numbers[j] < 0) 
				return false;
		}

		int i = 0;
		int temp;

		while (i < length) {
			if (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					*duplication = numbers[i];
					return true;
				} else {
					temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			} else {
				i++;
			}
		}
		return false;
	}
	
};
//int main() 
//{
//	
//	int a[] = { 2, 2, 2, 2, 2 };
//	solution s;
//	int* v;
//	s.duplicate(a, 5, v);
//	cout << v << endl;
//}