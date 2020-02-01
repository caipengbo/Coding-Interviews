package problem;

import util.Input;
import util.ListNode;
import util.ListUtil;

import java.io.*;

/**
 * Title: 删除链表的节点
 * Desc: 1. 删除给定节点, O(1)时间
 *       2.删除排序链表重复节点
 * Key: Java中的传参，特别是传 对象的时候，实际上传的只是一个对象名字（在栈中传递），对象在的实际内容都在Heap区
 * Created by Myth on 5/15/2019
 */
public class P18DeleteListNode {
    // 1. 删除给定节点, O(1)时间
    // 默认要删除的节点在链表内（注意为什么本函数用了返回值，这是因为Java中的传参特性）
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        // 链表为空，或者该链表只有一个节点（那么要删除的节点肯定是头结点）
        if (head == null || head.next == null) return null;
        ListNode p = head;
        // 要删除的节点是最后一个，从头遍历，找到要删除的节点d 前一个节点(倒数第二个节点)
        if (toBeDeleted.next == null) {
            while (p != null) {
                if (p.next == toBeDeleted) {
                    p.next = null;
                    return head;
                }
                p = p.next;
            }
        }
        // 要删除的节点在中间
        p = toBeDeleted.next;
        toBeDeleted.val = p.val;
        toBeDeleted.next = p.next;
        return head;
    }
    // LeetCode237：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    // 删除中间节点
    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 2. 删除排序链表重复节点(重复的节点保留)
    public static void deleteDuplicatedNode(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            if (q.val > p.val) {
                p.next = q;
                p = q;
            }
            q = q.next;
        }
        if (p.next != null) {
            p.next = null;
        }
    }
    // 删除排序链表重复节点(重复的节点不保留)
    public static ListNode deleteDuplicatedNode2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode pre = null;
        ListNode current = pHead;
        ListNode tail;
        while (current != null) {
            // 找到重复的开始位置
            if (current.next != null && current.next.val == current.val) {
                tail = current;
                while (tail.next != null && tail.next.val == current.val) {
                    tail = tail.next;
                }
                // 说明头部就是重复的
                if (pre == null) {
                    pHead = tail.next;
                } else {
                    pre.next = tail.next;
                }
                current = tail.next;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return pHead;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Input.getBufferReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            ListNode node = ListUtil.stringToListNode(line);
            ListNode head = node;
            ListUtil.prettyPrintLinkedList(head);

            head = P18DeleteListNode.deleteDuplicatedNode2(head);

            ListUtil.prettyPrintLinkedList(head);
            System.out.println("=========");
        }
    }
}
