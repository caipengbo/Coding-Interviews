package problem;

import util.TreeNode;

/**
 * Title: 28. 对称的二叉树
 * Desc: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by Myth on 6/1/2019
 */
public class P28SymmetricalBinaryTree {
    // 本质上是考察树的遍历，定义一种 前序对称(先遍历右子树，再遍历左子树)遍历算法
    // 如果 前序遍历 和 前序对称遍历 一致，那么这个二叉树就是对称的
    public static boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }
    public static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        else {
            return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
        }
    }
}
