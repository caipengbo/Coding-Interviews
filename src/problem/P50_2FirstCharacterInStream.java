package problem;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Title: 50.2 字符流中第一个不重复的字符
 * Desc: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * Created by Myth on 6/25/2019
 */
public class P50_2FirstCharacterInStream {
    // 使用哈希，Key是字符，Value是第一次出现的位置（如果重复出现，值置put为 无穷大）
    private HashMap<Character, Integer> hashMap = new HashMap<>();
    private int length = 0;
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (hashMap.containsKey(ch)) {
            hashMap.put(ch, Integer.MAX_VALUE);
        } else {
            hashMap.put(ch, length);
        }
        length++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '#';
        int min = length + 1;
        int cur;
        for (Character c : hashMap.keySet()) {
            cur = hashMap.get(c);
            if (cur < min) {
                ch = c;
                min = cur;
            }
        }
        return ch;
    }


}
