package problem;
import java.util.Arrays;

/**
* Title: 48. 最长不含重复字符的子字符串
* Desc: 
* Created by Myth-PC on 15/02/2020 in VSCode
*/
public class P48LongestWithoutRepeatingCharacters {
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