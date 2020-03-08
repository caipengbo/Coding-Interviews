package problem;

import util.TreeNode;

/**
 * Title: 最近公共祖先 
 * Desc: 二叉搜索树的、二叉树的 
 * Created by Myth-PC on 07/03/2020 in VSCode
 */
public class P68LowestCommonAncestor {
    // ================
    // 二叉搜索
    // ================
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 不在同一边，当前元素就是BST的最近公共祖先
        if (root == null || (root.val - p.val) * (root.val - q.val) <= 0) return root;
        // 在同一边，就递归去搜
        if (root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }


    // =================
    // 普通二叉树
    // =================
    // 1. 暴力搜索
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pPos = leftOrRight(root, p);
        int qPos = leftOrRight(root, q);
        if (root == null || pPos == -2 || qPos == -2 || pPos*qPos <= 0) return root;
        if (pPos == -1) return lowestCommonAncestor2(root.left, p, q);
        else return lowestCommonAncestor2(root.right, p, q);

    }
    // -1(左子树)   0(当前节点)   1(右子树)  -2(不在此子树)
    private int leftOrRight(TreeNode root, TreeNode node) {
        if (root == null) return -2;
        if (root.val == node.val) return 0;
        if (found(root.left, node)) return -1;
        if (found(root.right, node)) return 1;
        return -2;
    }
    private boolean found(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root.val == node.val) return true;
        return found(root.left, node) || found(root.right, node);
    }
    // 2. 解法2
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (left != null && right != null) return root;
        // 思考这一句
        return left == null ? right : left;
    }
    
}