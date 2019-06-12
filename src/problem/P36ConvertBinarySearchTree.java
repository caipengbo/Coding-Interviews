package problem;

import util.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 36. 二叉搜索树与双向链表
 * Desc: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *       要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by Myth on 6/12/2019
 */
public class P36ConvertBinarySearchTree {
    // 多组测试数据不要使用static
    private static TreeNode pLastNodeInList = null;
    public static TreeNode convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        TreeNode head = pLastNodeInList;
        if (head == null) return null;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
    // 中序遍历的基础
    public static void convertNode(TreeNode current) {
        if (current == null) return;
        if (current.left != null)
            convertNode(current.left);

        current.left = pLastNodeInList;
        if (pLastNodeInList != null)
            pLastNodeInList.right = current;
        pLastNodeInList = current;

        if (current.right != null)
            convertNode(current.right);
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test" + count + "=========================");
            TreeNode root = TreeUtil.stringToTreeNode(line);
            TreeNode p = P36ConvertBinarySearchTree.convert(root);
            while (p.right != null) {
                //System.out.println(p.val + " ");
                p = p.right;
            }
            while (p != null) {
                System.out.println(p.val + " ");
                p = p.left;
            }

            // TreeUtil.prettyPrintTree(root);
        }
    }
}
