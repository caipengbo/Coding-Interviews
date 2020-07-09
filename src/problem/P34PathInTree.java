package problem;

import util.Input;
import util.TreeNode;
import util.TreeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 34.二叉树中和为某一值的路径
 * Desc: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by Myth on 6/10/2019
 */
public class P34PathInTree {
    // 简洁代码
    public void findPath(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            // 注意必须new一个新的list
            if (root.val == sum) res.add(new LinkedList<>(path));
        }
        findPath(root.left, sum-root.val, path, res);
        findPath(root.right, sum-root.val, path, res);
        path.removeLast();
    }

    // 非常典型的 DFS 深度优先遍历
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        ArrayList<Integer> path = new ArrayList<>();
        int sum = 0;
        find(paths, path, root, target);
        return paths;
    }
    // 使用一个 sum 作为累加，不如每次减少 target，这样就可以少一个 sum 变量
    public static void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                paths.add(path);
            }
        } else if (target > 0) {
            ArrayList<Integer> path2=new ArrayList<>();
            path2.addAll(path);
            find(paths, path, root.left,target-root.val);
            find(paths, path2, root.right,target-root.val);
        }
    }
    // 优秀代码
    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    // 第二遍
    // LeetCode112：是否存在路径（简单的前序遍历）
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    // LeetCode113
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        recursive(root, sum, ret, new LinkedList<>());
        return ret;
    }
    public void recursive(TreeNode root, int sum, List<List<Integer>> ret, LinkedList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            ret.add(new LinkedList<>(path));
            // 下面两行代码可以去掉，这样就不在此处return，继续执行下面的recursive和最后的remove
            // 如果在此处return，则必须先remove再return
            path.removeLast();
            return;
        }
        recursive(root.left, sum-root.val, ret, path);
        recursive(root.right, sum-root.val, ret, path);
        path.removeLast();
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
            ArrayList a = P34PathInTree.FindPath(head, 22);
            System.out.println(a.toString());

        }
    }

}
