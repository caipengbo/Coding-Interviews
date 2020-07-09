package problem;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: 32.2 把二叉树打印成多行
 * Desc: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * Created by Myth on 6/5/2019
 */
public class P32_2PrintTreeInLInes {
     // 加个size
     class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
     public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            List<Integer> level = new ArrayList<>(nodeCount);
            for (int i = 0; i < nodeCount; i++) {
                Node node = queue.poll();
                level.add(node.val);
                for(Node child : node.children) {
                    if (child != null) queue.add(child);
                }
            }
            ret.add(level);
        }
        return ret;
    }
    // 和 32.1 题基本类似，主要不同点就是使用两个计数器
    public static ArrayList<ArrayList<Integer>> printInLines(TreeNode pRoot) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        int cur = 0; // 当前层的节点数目，逐步递减，直到为 0 时，为一行
        int next = 0; // 下一层节点数目，每一行结束后，cur = next
        if (pRoot != null) {
            queue.add(pRoot);
            cur++;
        }
        // 重点是 cur 和 next
        while (!queue.isEmpty()) {
            TreeNode first = queue.pop();
            line.add(first.val);
            cur--;
            if (first.left != null) {
                queue.add(first.left);
                next++;
            }
            if (first.right != null) {
                queue.add(first.right);
                next++;
            }
            if (cur == 0) {
                ret.add(line);
                line = new ArrayList<>();
                cur = next;
                next = 0;
            }

        }
        return ret;
    }

    // 递归写法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        recursive(ret, 0, root);
        return ret;
    }
    private void recursive(List<List<Integer>> ret, int level, TreeNode root) {
        if (root == null) return;
        if (level >= ret.size()) ret.add(new LinkedList<Integer>());
        List<Integer> line = ret.get(level);
        line.add(root.val);
        recursive(ret, level+1, root.left);
        recursive(ret, level+1, root.right);
    }
}
