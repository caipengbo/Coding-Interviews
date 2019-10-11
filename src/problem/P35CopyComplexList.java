package problem;

import util.ListNode;
import util.ListUtil;

import java.util.LinkedList;

/**
 * Title: 35. 复杂链表的复制
 * Desc: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的 head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * Created by Myth on 6/11/2019
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class P35CopyComplexList {
    // 1. 为每个结点创建一个副本next指向副本 2. 副本的random指向源节点的random.next 3. 拆分成两个链表
    public static RandomListNode clone(RandomListNode pHead) {
        pHead = dup(pHead);
        pHead = setRandom(pHead);
        RandomListNode newHead = split(pHead);
        return newHead;
    }
    //
    public static RandomListNode dup(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        return pHead;
    }
    public static RandomListNode setRandom(RandomListNode pHead) {
        RandomListNode cur = pHead;
        RandomListNode temp;
        while (cur != null) {
            temp = cur.next;
            if (cur.random == null) temp.random = null;
            else temp.random = cur.random.next;
            cur = temp.next;
        }
        return pHead;
    }
    // 自己的代码(出现错误)
    public static RandomListNode split(RandomListNode pHead) {
        if (pHead == null) return null;
        // pHead至少长度为2
        RandomListNode oldHead = pHead; // 奇数时 1
        RandomListNode newHead = pHead.next; // 偶数时 2
        RandomListNode p = oldHead, q = newHead;
        RandomListNode cur = newHead.next;  // 3
        int count = 3;
        while (cur != null) {
            if ((count & 0x1) == 1) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur = cur.next;
            count++;
        }
        pHead = oldHead;
        return newHead;
    }
    // 参考后的代码
    public static RandomListNode split2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = pHead.next;
        RandomListNode temp;
        RandomListNode cur = pHead;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return newHead;
    }
    // 更好的写法
    public static ListNode split3(ListNode head) {
        if (head == null) return null;
        ListNode p = head, q = head.next;
        ListNode evenHead = head.next;
        while (p.next != null && p.next.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = p.next;
        }
        p.next = null;  // 封尾操作(该题比较特殊，如果是单纯的将一个链表拆成一个，需要进行封尾)
        return head;
    }

    private void debug() {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node1.random = node4;
        node2.random = null;
        node3.random = node2;
        node4.random = node3;
//        RandomListNode h = P35CopyComplexList.clone(node1);
//        while (h != null) {
//            System.out.print(h.label + " ");
//            h = h.next;
//        }
        RandomListNode h = P35CopyComplexList.dup(node1);
//        while (h != null) {
//            System.out.print(h.label + " ");
//            h = h.next;
//        }
        System.out.println();
        RandomListNode h2 = P35CopyComplexList.setRandom(h);
        while (h2 != null) {
            if (h2.random != null) {
                System.out.print(h2.random.label + " ");
            } else {
                System.out.print("X" + " ");
            }
            h2 = h2.next;
        }
        System.out.println();
        RandomListNode h3 = P35CopyComplexList.split(node1);
        while (h3 != null) {
            System.out.print(h3.label + " ");
            h3 = h3.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode root = ListUtil.stringToListNode("[1,2]");
        ListUtil.prettyPrintLinkedList(P35CopyComplexList.split3(root));
    }
}
