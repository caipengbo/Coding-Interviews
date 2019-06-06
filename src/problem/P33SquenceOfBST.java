package problem;


import java.util.ArrayList;

/**
 * Title: 33. 二叉搜索树的后序遍历序列
 * Desc: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出 Yes,否则输出 No。
 *       假设输入的数组的任意两个数字都互不相同。
 * Created by Myth on 6/6/2019
 */
public class P33SquenceOfBST {
    // 注意二叉搜索树的特点：左小右大
    public static boolean verifySquenceOfBST(int [] sequence) {
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i : sequence) {
            seq.add(i);
        }
        if (seq.isEmpty()) return false;
        return verify(seq);
    }
    // flag 0 left ( < root),  1 right ( > root)
    public static boolean verify(ArrayList<Integer> sequence) {
        int len = sequence.size();
        if (len == 0 || len == 1) return true;
        ArrayList<Integer> leftSequence = new ArrayList<>();
        ArrayList<Integer> rightSequence = new ArrayList<>();
        int i = 0;
        // 分割成两部分
        while (i < len-1 && sequence.get(i) < sequence.get(len - 1)) {
            leftSequence.add(sequence.get(i));
            i++;
        }
        for (int j = i; j < len-1; j++) {
            rightSequence.add(sequence.get(j));
        }
        // 判断右侧是否符合都比根节点小的要求
        for(Integer integer : rightSequence) {
            if (sequence.get(len - 1) > integer) {
                return false;
            }
        }
        return verify(leftSequence) && verify(rightSequence);
    }
}
