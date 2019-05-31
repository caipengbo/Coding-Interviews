package problem;

import util.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 26. 树的子结构
 * Desc: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * Created by Myth on 5/31/2019
 */
public class P26SubstructureInTree {
    // 1. 找相同的根节点  2. 判断是否结构相同
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            boolean same = sameStructure(root1, root2);
            if (!same) {
                return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
            }
            return true;
        }
        return false;
    }
    public static boolean sameStructure(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return sameStructure(root1.left, root2.left) && sameStructure(root1.right, root2.right);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("========== Test" + count + "=========================");
            TreeNode root1 = TreeUtil.stringToTreeNode(line);
            line = bufferedReader.readLine();
            TreeNode root2 = TreeUtil.stringToTreeNode(line);
            System.out.println(hasSubtree(root1, root2));
        }
    }
}
