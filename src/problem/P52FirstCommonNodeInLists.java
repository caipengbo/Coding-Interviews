package problem;

import util.ListNode;

/**
 * Title: 52. 两个链表的第一个公共结点
 * Desc: 输入两个链表，找出它们的第一个公共结点
 * Created by Myth on 6/27/2019
 */
public class P52FirstCommonNodeInLists {
    // 如果有公共节点，那么这两个链表会从第一个公共节点重合, 不会分叉！！！
    // 设置两个指针，分别指向两个链表(长度分别为 m > n )，较长的指针先走m-n步，然后同步走，直到遇到一样的节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int count1 = getLength(pHead1);
        int count2 = getLength(pHead2);
        int distance;
        if (count1 > count2) {
            distance = count1 - count2;
            while (distance != 0) {
                distance--;
                pHead1 = pHead1.next;
            }
        } else {
            distance = count2 - count1;
            while (distance != 0) {
                distance--;
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
    private int getLength(ListNode pHead) {
        int count = 0;
        while (pHead != null) {
            count++;
            pHead = pHead.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        P52FirstCommonNodeInLists p52 = new P52FirstCommonNodeInLists();
        ListNode commonNode = p52.FindFirstCommonNode(node1, node4);
        System.out.println(commonNode.val);

    }
}
