package problem;

import util.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 54.二叉搜索树的第 k 个结点
 * Desc: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如,
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * Created by Myth on 7/1/2019
 */
public class P54KthNodeInBST {
    // 本质： 二叉搜索树的中序遍历
    private int k;
    private TreeNode target = null;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0 || pRoot == null) return null;
        this.k = k;
        return core(pRoot);
    }
    private TreeNode core(TreeNode pRoot) {
        // 左边找
        if (pRoot.left != null) {
            target = core(pRoot.left);
        }
        // 中序遍历，在中间进行计数
        if (target == null) {
            if (k == 1) target = pRoot;
            k--;
        }
        // 右边找
        if (target == null && pRoot.right != null) {
            target = core(pRoot.right);
        }
        return target;
    }
    // TODO:重点题目，多写几遍

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test Tree" + count + "=========================");
            TreeNode root = TreeUtil.stringToTreeNode(line);

            P54KthNodeInBST p54 = new P54KthNodeInBST();
            TreeNode node = p54.KthNode(root, 3);
            System.out.println(node.val);
        }
    }
}
