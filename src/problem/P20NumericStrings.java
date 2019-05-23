package problem;

/**
 * Title: 表示数值的字符串
 * Desc: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by Myth on 5/23/2019
 */
public class P20NumericStrings {
    // 字符串遵循模式 A[.[B]][e|EC], A 和 C 是有符号整数（可以有+ - 号）， B是无符号整数
    public static int cur = 0;

    public static boolean isNumeric(char[] str) {
        int len = str.length;
        if (len == 0) return false;
        boolean ret = scanInteger(str);
        if (cur <  len && str[cur] == '.') {
            cur++;
            ret = scanUnsignedInteger(str) || ret;
        }
        if (cur <  len && (str[cur] == 'e' || str[cur] == 'E') ) {
            cur++;
            ret = ret && scanInteger(str);
        }
        return ret && (cur == len);
    }
    public static boolean scanInteger(char[] str) {
        int len = str.length;
        if (cur <  len && (str[cur] == '+' || str[cur] == '-')) {
            cur++;
        }
        return scanUnsignedInteger(str);
    }
    public static boolean scanUnsignedInteger(char[] str) {
        int matchCount = 0;
        int len = str.length;
        while (cur <  len && str[cur] >= '0' && str[cur] <= '9') {
            cur++;
            matchCount++;
        }
        return  (matchCount > 0);
    }

    public static void main(String[] args) {
        char[] str = {'-', '1', '0', '0', 'E', '-', '6'};
        System.out.println(P20NumericStrings.isNumeric(str));
    }
}
