package problem;

import util.TreeNode;

/**
 * Title: 最近公共祖先 Desc: 二叉搜索树的、二叉树的 Created by Myth-PC on 07/03/2020 in VSCode
 */
public class P68LowestCommonAncestor {
    // 二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 不在同一边，当前元素就是BST的最近公共祖先
        if (root == null || (root.val - p.val) * (root.val - q.val) <= 0) return root;
        // 在同一边，就递归去搜
        if (root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
    
}