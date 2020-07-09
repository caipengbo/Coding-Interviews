package problem;

/**
 * Title: 46. 把数字翻译成字符串
 * Desc: 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，
 * 1 翻译成 “b”，
 * ……，
 * 11 翻译成 “l”，……，
 * 25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 * Created by Myth on 6/23/2019
 */
public class P46TranslateNumber {
    // 
    public int translateNum(int num) {
        if (num < 10) return 1;
        if (num <= 25) return 2;
        String str = String.valueOf(num);
        int dp0, dp1, cur;
        dp0 = 1;
        dp1 = ((str.charAt(0)-'0')*10+(str.charAt(1)-'0') <= 25) ? 2 : 1;
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i-1) != '0' && (str.charAt(i-1)-'0')*10+(str.charAt(i)-'0') <= 25) cur = dp0 + dp1;
            else cur = dp1;
            dp0 = dp1;
            dp1 = cur;
        }
        return dp1;
    }

}
