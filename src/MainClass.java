import problem.P18DeleteListNode;
import problem.P25MergeSortedLists;
import util.Input;
import util.ListNode;
import util.ListUtil;

import java.io.*;

/**
 * Title:
 * Desc:
 * Created by Myth on 5/12/2019
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        int count = 0;
        String line;
        BufferedReader bufferedReader = Input.getBufferReader();

        while ((line = bufferedReader.readLine()) != null) {
            count++;
            System.out.println("==========Test" + count + "=========================");
            ListNode head = ListUtil.stringToListNode(line);


            ListUtil.prettyPrintLinkedList(head);
        }
    }
}