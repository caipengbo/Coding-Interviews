package problem;

import util.TreeNode;

/**
* Title:  7.  重建二叉树（LeetCode105）
* Desc: 前、中序重建二叉树
* Created by Myth-PC on 27/01/2020 in VSCode
*/
public class P7ReconstructTree {
    // 分治
    int cur;
    int[] pre;
    int[] in;
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.pre = pre;
        this.in = in;
        cur = 0;
        return construct(0, pre.length-1);
    }
    private TreeNode construct(int left, int right) {
        if (cur >= pre.length || left > right) return null;
        TreeNode root = new TreeNode(pre[cur]);
        int i;
        for (i = left; i <= right; i++) {
            if (pre[cur] == in[i]) break;
        }
        cur++;
        root.left = construct(left, i-1);
        root.right = construct(i+1, right);
        return root;
    }
    public static void main(String[] args) {
        
    }
}