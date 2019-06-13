package problem;

import util.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 37. 序列化二叉树
 * Desc: 请实现两个函数，分别用来序列化和反序列化二叉树
 * Created by Myth on 6/13/2019
 */
public class P37SerializeBinaryTree {
    // 重点：在Java中如何控制参数（传参 or 成员变量）
    // 空指针使用 $ 序列使用, 隔开
    String serializedStr = "";
    public String serialize(TreeNode root) {
        serializeTree(root);
        serializedStr = serializedStr.substring(0, serializedStr.length()-1);
        return serializedStr;
    }
    public void serializeTree(TreeNode root) {
        if (root == null) {
            serializedStr += "$,";
            return;
        }
        serializedStr += String.valueOf(root.val) + ",";
        serializeTree(root.left);
        serializeTree(root.right);
    }
    public TreeNode deserialize(String str) {
       String[] vals = str.split(",");
       return deserializeStr(vals);
    }
    int index = -1;
    public TreeNode deserializeStr(String[] vals) {
        index++;
        if (index >= vals.length) return null;
        if (!vals[index].equals("$")) {
            TreeNode treeNode = new TreeNode(Integer.parseInt(vals[index]));
            treeNode.left = deserializeStr(vals);
            treeNode.right = deserializeStr(vals);
            return treeNode;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test Tree" + count + "=========================");
            // TreeNode root = TreeUtil.stringToTreeNode(line);
            P37SerializeBinaryTree p37 = new P37SerializeBinaryTree();
            // String str = p37.serialize(root);
            // System.out.println(str);
            TreeNode root = p37.deserialize("1,2,$,$,4,$,$");
            TreeUtil.prettyPrintTree(root);
        }
    }
}
