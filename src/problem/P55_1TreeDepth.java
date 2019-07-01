package problem;

import util.TreeNode;

/**
 * Title: 55.1 二叉树的深度
 * Desc: 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * Created by Myth on 7/1/2019
 */
public class P55_1TreeDepth {

    public int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth+1 : rightDepth+1);
    }
}
