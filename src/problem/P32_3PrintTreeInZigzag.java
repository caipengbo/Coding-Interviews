package problem;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Title: 32.3 之字形打印二叉树
 * Desc: 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by Myth on 6/5/2019
 */
public class P32_3PrintTreeInZigzag {
    // 显然是用栈实现，需要两个栈 奇数层栈 和 偶数层栈
    // 奇数层的时候，使用奇数栈（左子树先入偶数栈，然后是右子树）；偶数层时候，使用偶数栈（右子树先入奇数栈，左子树再入栈）
    public ArrayList<ArrayList<Integer>> printInZigzag(TreeNode pRoot) {
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        if (pRoot != null) {
            oddStack.push(pRoot);
        }
        // 重点是 cur 和 next
        while (!oddStack.empty() || !evenStack.empty()) {
            while (!oddStack.empty()) {
                TreeNode top = oddStack.pop();
                line.add(top.val);
                if (top.left != null) {
                    evenStack.push(top.left);
                }
                if (top.right != null) {
                    evenStack.push(top.right);
                }
            }
            if (!line.isEmpty()) {
                ret.add(line);
                line = new ArrayList<>();
            }
            while (!evenStack.empty()) {
                TreeNode top = evenStack.pop();
                line.add(top.val);
                if (top.right != null) {
                    oddStack.push(top.right);
                }
                if (top.left != null) {
                    oddStack.push(top.left);
                }
            }
            if (!line.isEmpty()) {
                ret.add(line);
                line = new ArrayList<>();
            }
        }
        return ret;
    }
}
