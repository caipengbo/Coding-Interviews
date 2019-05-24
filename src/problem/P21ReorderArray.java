package problem;

/**
 * Title: 调整数组顺序使奇数位于偶数前面
 * Desc: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *   如果不用保证 奇数和奇数，偶数和偶数之间的相对位置不变，该题很简单
 *   一个指针从前往后，一个指针从后往前，遇到前偶后奇的情况，就交换两个位置的元素, 但是这种解法会打乱位置
 * Created by Myth on 5/24/2019
 */
public class P21ReorderArray {
    // 如果要保证相对位置不变，一种解法是，再开辟一个等长的数组，然后统计奇偶的数目，然后从合适的位置填充
    public static void reOrderArray(int [] array) {
        int len = array.length;
        int[] cloneArray = array.clone();
        int oddNum = 0;
        for (int i = 0; i < len; i++) {
            if ((cloneArray[i] & 1) == 1) { // 奇数
                oddNum++;
            }
        }
        int j = 0;
        for (int i = 0; i < len; i++) {
            if ((cloneArray[i] & 1) == 1) { // 奇数
                array[j++] = cloneArray[i];
            } else {
                array[oddNum++] = cloneArray[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        P21ReorderArray.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
