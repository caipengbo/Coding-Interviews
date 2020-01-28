package problem;

/**
* Title: 二叉树的下一个结点
* Desc: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
* Created by Myth-PC on 28/01/2020 in VSCode
*/
public class P8GetNextNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
    
        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        
        while (pNode.next != null) {
            if (pNode == pNode.next.left) return pNode.next;
            pNode = pNode.next;
        }

        return null;
    }
}