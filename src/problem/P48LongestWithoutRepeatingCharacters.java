package problem;
import java.util.Arrays;

/**
* Title: 48. 最长不含重复字符的子字符串
* Desc: 使用两个指针p, q，没有重复的时候q++,有重复的时候p++，使用一个字典记录是否重复
* Created by Myth-PC on 15/02/2020 in VSCode
*/
public class P48LongestWithoutRepeatingCharacters {
    // abacdeb
    public int lengthOfLongestSubstringNew(String s) {
        int[] dic = new int[256];  // Hash记录出现的次数
        int p = 0, q = 0, n = s.length();
        int max = 0;
        while (p <= q && p < n) {
            // 前指针用来在hash中加数
            if (q < n && dic[s.charAt(q)] == 0) {
                dic[s.charAt(q)]++;
                q++;
            } else {
                // 后指针用来排除
                dic[s.charAt(p)]--;
                p++;
            }
            max = Math.max(max, q-p);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        boolean[] repeated = new boolean[256];
        int p = 0;
        int max = 1;
        for (int q = 0; q < s.length(); q++) {
            if (!repeated[s.charAt(q)]) {
                repeated[s.charAt(q)] = true;
            } else {
                max = Math.max(max, q - p);
                while (s.charAt(p) != s.charAt(q)) {
                    repeated[s.charAt(p)] = false;
                    p++;
                }
                // repeated[s.charAt(q)] = q;
                p++;
            } 
        }
        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) return s.length();
        boolean[] repeated = new boolean[256];
        int p = 0, q;
        int max = 1;
        for (q = 0; q < s.length(); q++) {
            if (repeated[s.charAt(q)]) {
                max = Math.max(max, q - p);
                while (s.charAt(p) != s.charAt(q)) {
                    repeated[s.charAt(p)] = false;
                    p++;
                }
                p++;
            }
            repeated[s.charAt(q)] = true;
        }
        max = Math.max(max, q - p);
        return max;
    }

}