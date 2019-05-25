package problem;

import util.Input;
import util.ListNode;
import util.ListUtil;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 链表中倒数第 k 个结点
 * Desc: 输入一个链表，输出该链表中倒数第 k 个结点。（从 1 计数）
 * Created by Myth on 5/25/2019
 */
public class P22KthNodeFromEnd {
    // 两个指针 prior  ———— k-1 ———— tail， tail指针到尾部的时候，prior 正好在倒数第 K 的位置
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode prior = head;
        ListNode tail = head;
        int i = 0;
        while (i < k && tail != null) {
            tail = tail.next;
            i++;
        }
        // 链表长度不足 k
        if (i != k) return null;
        while (tail != null) {
            prior = prior.next;
            tail = tail.next;
        }
        return prior;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Input.getBufferReader();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            ListNode head = ListUtil.stringToListNode(line);
            ListUtil.prettyPrintLinkedList(head);
            ListNode node = P22KthNodeFromEnd.findKthToTail(head, 3);
            System.out.println("=========================" + node.val);
        }
    }
}
