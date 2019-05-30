package problem;

import util.Input;
import util.ListNode;
import util.ListUtil;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Title: 25. 合并两个排序的链表
 * Desc:  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * Created by Myth on 5/30/2019
 */
public class P25MergeSortedLists {
    public static ListNode mergeError(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        mergedList = mergeToAList(mergedList, list1, list2);
        return mergedList;
    }
    // 编写递归时候出现问题！！ 不知道该如何组织指针的移动！！！
    public static ListNode mergeToAList(ListNode mergedList, ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return mergedList;
        }
        if (list1 == null || list2 == null) {
            if (mergedList == null) {
                mergedList = (list1 != null? list1:list2);
            } else {
                mergedList.next = (list1 != null? list1:list2);
            }
            return mergedList;
        }
        ListNode temp;
        if (list1.val <= list2.val) {
            temp = list1.next;
            list1.next = null;
            if (mergedList == null) {
                mergedList = list1;
            } else {
                mergedList.next = list1;
            }
            list1 = temp;
        } else {
            temp = list2.next;
            list2.next = null;
            if (mergedList == null) {
                mergedList = list2;
            } else {
                mergedList.next = list2;
            }
            list2 = temp;
        }
        // 出现问题！！！ mergedList 永远是合并后的指针的头结点，只在头结点操作！！！
        return mergeToAList(mergedList, list1, list2);
    }
    // 正确的递归代码
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode mergedList;
        if (list1.val <= list2.val) {
            mergedList = list1;
            mergedList.next = merge(list1.next, list2);
        } else {
            mergedList = list2;
            mergedList.next = merge(list1, list2.next);
        }
        return mergedList;
    }
    // 非递归版本
    public static ListNode merge2(ListNode list1, ListNode list2) {
        // 先在头部设置一个头部指针（为了简化下面的代码）
        ListNode mergedHead = new ListNode(-1);
        ListNode mergedTail = mergedHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedTail.next = list1;
                list1 = list1.next;
            } else {
                mergedTail.next = list2;
                list2 = list2.next;
            }
            mergedTail = mergedTail.next;
        }

        if (list1 == null) {
            mergedTail.next = list2;
        }
        if (list2 == null) {
            mergedTail.next = list1;
        }
        // 去除头部辅助指针
        mergedHead = mergedHead.next;
        return mergedHead;
    }


    public static void test(ListNode list1, ListNode list2) {
        list1 = list2;
        list2 =list2.next;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test" + count + "=========================");
            ListNode list1 = ListUtil.stringToListNode(line);
            line = bufferedReader.readLine();
            ListNode list2 = ListUtil.stringToListNode(line);
            ListNode merged = P25MergeSortedLists.merge2(list1, list2);
            ListUtil.prettyPrintLinkedList(merged);
        }
    }
}
