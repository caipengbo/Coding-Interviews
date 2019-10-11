package problem;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

/**
 * Title: 50.1 第一个只出现一次的字符
 * Desc: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *  并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * Created by Myth on 6/24/2019
 */
public class P50_1FirstNotRepeatingChar {
    // 返回第一个字符
    // 哈希方法 使用LinkedHashMap（可以保持 Key的顺序）这种方法
    public Character getFirstChar(String str) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                Integer val = hashMap.get(c);
                hashMap.put(c, ++val);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Character c : hashMap.keySet()) {
            if (hashMap.get(c) == 1) return c;
        }
        return null;
    }
    // 第一遍遍历串统计每个字符的数目，第二遍 遍历串 找到
    public int getFirstCharPosition(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                Integer val = hashMap.get(c);
                hashMap.put(c, ++val);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        P50_1FirstNotRepeatingChar p50 = new P50_1FirstNotRepeatingChar();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
