package problem;

import util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title: 32.1 从上往下打印二叉树
 * Desc: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * Created by Myth on 6/4/2019
 */
public class P32_1PrintTreeFromTopToBottom {
    // 层次打印，搞一个队列, 然后前序遍历即可
    // 二叉树遍历算法的非递归写法
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.pop();
            ret.add(first.val);
            if (first.left != null) {
                queue.add(first.left);
            }
            if (first.right != null) {
                queue.add(first.right);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test" + count + "=========================");
            TreeNode head = TreeUtil.stringToTreeNode(line);
            TreeUtil.prettyPrintTree(head);
            ArrayList a = P32_1PrintTreeFromTopToBottom.printFromTopToBottom(head);
            System.out.println(a.toString());

        }
    }
}
