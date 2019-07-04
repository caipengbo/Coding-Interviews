package problem;

import java.util.ArrayList;

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
}
