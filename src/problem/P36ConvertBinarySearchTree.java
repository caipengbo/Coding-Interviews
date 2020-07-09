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
    // 多组测试数据不要使用 static
    private static TreeNode pLastNodeInList = null;
    public static TreeNode convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        TreeNode head = pLastNodeInList;
        if (head == null) return null;
        // 找到头
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
    // 以中序遍历为基础
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

    // 第二遍
    // left前指针  right后指针
    public TreeNode convert2(TreeNode root) {
        if (root == null) return null;
        pre = null;
        convertHelper(root);
        TreeNode p = root;
        while(p.left != null) p = p.left;
        return p;
    }
    // 中序遍历 记录前一个访问的节点
    // 注意 这样传pre的值是不会改变pre的
    public void convertHelper(TreeNode cur, TreeNode pre) {
        if (cur == null) return;
        convertHelper(cur.left, pre);

        cur.left = pre;
        if (pre != null) pre.right = cur;
        pre = cur;

        convertHelper(cur.right, pre);
    }
    // 修改
    TreeNode pre = null;
    public void convertHelper(TreeNode cur) {
        if (cur == null) return;
        convertHelper(cur.left);

        cur.left = pre;
        if (pre != null) pre.right = cur;
        pre = cur;

        convertHelper(cur.right);
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();
        P36ConvertBinarySearchTree p36 = new P36ConvertBinarySearchTree();
        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test" + count + "=========================");
            TreeNode root = TreeUtil.stringToTreeNode(line);
            TreeUtil.prettyPrintTree(root);
            TreeNode p = p36.convert2(root);
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
