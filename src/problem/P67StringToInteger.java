package problem;

import java.util.Arrays;

/**
* Title: 67. 把字符串转换成整数
* Desc: 
- 第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号
- 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
- 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、
- 字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
- 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
-2147483648
214 748 364 7

* Created by Myth-PC on 03/03/2020 in VSCode
*/
public class P67StringToInteger {

    public int strToInt(String str) {
        char[] strs = str.toCharArray();
        int i, n = strs.length;
        // 跳过前导0
        for (i = 0; i < n; i++) {
            if (strs[i] != ' ') break;
        }
        // 开头是无效字符，退出
        if (i == n || (strs[i] != '+' && strs[i] != '-'  && !(strs[i] >= '0' && strs[i] <= '9'))) return 0;
        // 确定符号
        int symbol = 1;
        if (strs[i] == '-' || strs[i] == '+') {
            if (strs[i] == '-') symbol = -1;
            i++;
        }
        // 无数字，退出
        if (i == n || !(strs[i] >= '0' && strs[i] <= '9')) return 0;
        // 整数部分，注意越界问题
        // -2147483648    2147483647
        int VALUE = Integer.MAX_VALUE / 10;
        int ret = strs[i++] - '0';
        
        for (; i < n; i++) {
            if (!(strs[i] >= '0' && strs[i] <= '9')) break;
            if (ret > VALUE) return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int cur = strs[i]-'0';
            if (ret == VALUE) {
                if (symbol == 1 && cur >= 7) return Integer.MAX_VALUE;
                if (symbol == -1 && cur > 7) return Integer.MIN_VALUE;
            }
            ret = ret * 10 + cur;
        }
        return symbol * ret;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}