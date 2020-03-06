package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 57.2 和为 S 的连续正数序列  1 2 3 4 5 6
 * Desc: 输出所有和为S的连续正数序列(至少含有两个数字)。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * Created by Myth on 7/4/2019
 */
public class P57_2ContinuousSequenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum < 3) return ret;
        // 使用两个指针来改变序列的长度，终止条件是 small==mid
        int small = 1, big = 2;
        int mid = (sum + 1) >> 1;
        int curSum;
        while (small < mid) {
            curSum = 0;
            for (int i = small; i <= big; i++) {
                curSum += i;
            }
            if (curSum == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    arrayList.add(i);
                }
                ret.add(arrayList);
                big++;
            } else if (curSum > sum) { // 从当前序列中去掉较小的(small增加)
                small++;
            } else { // 增加序列（big增加）
                big++;
            }
        }
        return ret;
    }
    // 正整数序列，至少含有两个数
    public int[][] findContinuousSequence(int target) {
        if (target < 3) return new int[0][];
        int i = 1, j = 2;
        int sum = 3;
        List<int[]> seqs = new LinkedList<>();
        while (j - i >= 1 && i + j <= target) {
            if (sum > target) {
                sum -= i++;
            } else if (sum < target) {
                sum += (++j);
            } else {
                int len = j-i+1;
                int[] seq = new int[len];
                for (int k = 0; k < len; k++) {
                    seq[k] = i+k;
                }
                seqs.add(seq);
                sum = sum - (i++) + (++j);
            }
        }
        return seqs.toArray(new int[seqs.size()][]);
    }
    // 第三遍：简洁版
    public static int[][] findContinuousSequence3(int target) {
        // 至少有两个元素
        List<int[]> ret = new LinkedList<>();
        int i = 1, j = 2;
        target -= i+j;
        while (i < j) {
            if (target == 0) {
                int[] arr = new int[j-i+1];
                for (int k = i; k <= j; k++) arr[k-i] = k;
                ret.add(arr);
                target += i++;
                target -= ++j;
            } else if (target > 0) target -= ++j;
            else target += i++;
        }
        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        P57_2ContinuousSequenceWithSum p57 = new P57_2ContinuousSequenceWithSum();
        System.out.println(Arrays.toString(p57.findContinuousSequence(15)));
    }
}
