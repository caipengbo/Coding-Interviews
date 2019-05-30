package problem;

import util.Input;
import util.ListNode;
import util.ListUtil;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 24. 反转链表
 * Desc: 输入一个链表，反转链表后，输出新链表的表头。
 * Created by Myth on 5/28/2019
 */
public class P24ReverseList {
    // 定义三个指针 p  cur  q
    // cur.next = p q.nexy = cur | p = cur   cur = q  q = q.next
    public static ListNode ReverseList(ListNode head) {
        // 重点： 如何放置 三个指针的位置
        if (head == null || head.next == null) return head;
        ListNode cur = head, p = head, q = head;
        cur = head.next;
        if (cur.next == null) {
            cur.next = p;
            p.next = null;
            return cur;
        } else {
            q = cur.next;
        }
        // 以前的首节点置为尾节点
        p.next = null;
        while (q.next != null) {
            cur.next = p;
            p = cur;
            cur = q;
            q = q.next;
            cur.next = p;
        }
        cur.next = p;
        q.next = cur;
        return q;
    }
    public static ListNode ReverseList1(ListNode head) {
        ListNode p = null, cur = head, reversedHead = null;
        ListNode q;
        while (cur != null) {
            q = cur.next;
            // 找到尾节点
            if (q == null) {
                reversedHead = cur;
            }
            // 每次拆一个
            cur.next = p;
            p = cur;
            cur = q;
        }
        return reversedHead;
    }

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();
        while ((line = bufferedReader.readLine()) != null) {
            ListNode head = ListUtil.stringToListNode(line);
            head = P24ReverseList.ReverseList1(head);
            ListUtil.prettyPrintLinkedList(head);
            System.out.println("=========================");
        }

    }
}
