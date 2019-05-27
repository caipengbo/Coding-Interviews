package problem;

import util.ListNode;

/**
 * Title: 23. 链表中环的入口结点
 * Desc: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * Created by Myth on 5/27/2019
 */
public class P23EntryNodeInListLoop {
    // 找到 环中 任意一个节点
    // 根据这个节点统计环中元素的数目 n
    // 让快指针先走 n 步，然后慢指针再走，当两指针相遇的时候，就是入口节点
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        // 找到 环中 任意一个节点
        ListNode fast = pHead, slow = pHead;

        fast = fast.next;
        if (fast != null) fast = fast.next;
        else return null;
        ListNode meetNode;
        while (fast != null && fast != slow) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else return null;
            slow = slow.next;
        }
        if (fast == null) return null;
        else meetNode = fast;
        // 根据这个节点统计环中元素的数目 n
        int count = 1;
        for (fast = fast.next; fast != meetNode; fast=fast.next){
            count++;
        }
        System.out.println(count);
        // 让快指针先走 n 步，然后慢指针再走，当两指针相遇的时候，就是入口节点
        fast = pHead;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node6.next = null;

        ListNode entry = P23EntryNodeInListLoop.EntryNodeOfLoop(node1);
        System.out.println(entry.val);

    }
}
