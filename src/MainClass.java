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
        File file = new File("src/input.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            ListNode node = ListUtil.stringToListNode(line);


            ListUtil.prettyPrintLinkedList(node);
        }
    }
}