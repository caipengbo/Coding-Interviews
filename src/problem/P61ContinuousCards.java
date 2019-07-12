package problem;

import java.util.Arrays;

/**
 * Title: 61. 扑克牌中的顺子
 * Desc: 从扑克牌中抽5张牌，判断是不是顺子，2~10看成数字本身，A看做 1，J看做11，Q看做12，K看做13，大小王看成任意数字
 * Created by Myth on 7/12/2019
 */
public class P61ContinuousCards {
    // 大小王当成0;对数组进行排序, 如果排序后连续数字间隔小于等于0的个数，那么是顺子，反之不是；特别的，带有重复数字，不符合要求
    // 难点：如何求连续间隔？？？
    public boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) return false; // 默认输入的数字都是小于等于13的
        // Arrays.sort(numbers);
        int[] countsArray = new int[14];
        // Arrays.fill(countsArray, -1);
        for (int i = 0; i < 5; i++) {
            countsArray[numbers[i]]++;
            if (numbers[i] != 0 && countsArray[numbers[i]] > 1) return false;
        }
        // 统计间隔
        int oneCount = 0;
        int notContinuous = 0;
        for (int i = 1; i < 14; i++) {
            if (countsArray[i] == 1) oneCount++;
            if (oneCount == (5-countsArray[0])) break;
            if (oneCount != 0 && countsArray[i] == 0) notContinuous++;
        }
        // System.out.println(notContinuous);
        // System.out.println(oneCount);
        return notContinuous <= countsArray[0];
    }

    public static void main(String[] args) {
        P61ContinuousCards p61 = new P61ContinuousCards();
        int[] arr = {1,3,0,5,0};
        System.out.println(p61.isContinuous(arr));
    }
}
