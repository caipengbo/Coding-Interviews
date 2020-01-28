package problem;

import java.util.ArrayList;

import util.ListNode;

/**
 * Title: 6. 从后往前打印链表 
 * Desc: 
 * Created by Myth-PC on 27/01/2020 in VSCode
 */

public class P6PrintListFromTail {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        print(listNode, ret);
        return ret;
    }
    public void print(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null) return;
        print(listNode.next, list);
        list.add(listNode.val);
    }
    
}