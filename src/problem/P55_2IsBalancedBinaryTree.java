package problem;

import util.TreeNode;

/**
 * Title: 55.2 判断是否是平衡二叉树
 * Desc: 输入一棵二叉树，判断该二叉树是否是平衡二叉树（左右子树深度相差不超过 1）。
 * Created by Myth on 7/1/2019
 */
public class P55_2IsBalancedBinaryTree {
    // 一种思路是在55.1的基础上判断是否所有的深度相差都不超过 1，这种算法重复遍历了很多节点
    //
    public boolean isBalanced(TreeNode root) {
        return (getDepth(root) == -1);
    }
    // 第二种方法，添加一个返回值，用来提前返回
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}
