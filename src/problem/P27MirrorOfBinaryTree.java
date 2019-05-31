package problem;

import util.TreeNode;

/**
 * Title: 27. 二叉树的镜像
 * Desc: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * Created by Myth on 5/31/2019
 */
public class P27MirrorOfBinaryTree {
    // 交换非叶子结点的左、右子节点
    public static void mirrorRecursively(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorRecursively(root.left);
            mirrorRecursively(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
