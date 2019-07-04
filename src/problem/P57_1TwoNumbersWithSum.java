package problem;

import java.util.ArrayList;

/**
 * Title: 57.1 和为 S 的两个数字
 * Desc: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * Created by Myth on 7/4/2019
 */
public class P57_1TwoNumbersWithSum {
    // 两个指针，一前一后，和 大于 数字sum的时候，后面的指针往前，使和变小； 和小于 数字sum的时候，前面的指针往后，使得和变大
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(array == null || array.length < 2) return ret;
        int head = 0, tail = array.length - 1;
        int curSum;
        while (head < tail) {
            curSum = array[head] + array[tail];
            if (curSum == sum) {
                ret = new ArrayList<>();
                ret.add(array[head]);
                ret.add(array[tail]);
                break;
            } else if (curSum < sum){
                head++;
            } else {
                tail--;
            }
        }
        return ret;
    }
}
