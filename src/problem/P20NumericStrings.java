package problem;

/**
 * Title: 表示数值的字符串
 * Desc: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by Myth on 5/23/2019
 */
public class P20NumericStrings {
    // 字符串遵循模式 [A][.[B]][e|EC], A 和 C 是有符号整数（可以有+ - 号）， B是无符号整数
    public static int cur = 0;

    public static boolean isNumericOld(char[] str) {
        int len = str.length;
        if (len == 0) return false;
        boolean ret = scanInteger(str);
        if (cur <  len && str[cur] == '.') {
            cur++;
            // 必须是ret 在后面，因为如果 ret 为 True 的话就会导致scanUnsignedInteger不执行
            // .1314  1314. 都符合条件
            ret = scanUnsignedInteger(str) || ret;
        }
        if (cur <  len && (str[cur] == 'e' || str[cur] == 'E') ) {
            cur++;
            // E前面和后面必须都要有整数
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
    // 自动机写法
    private int op(char ch) {
        if (ch == '+' || ch == '-') return 0;
        if (ch >= '0' && ch <= '9') return 1;
        if (ch == 'e' || ch == 'E') return 2;
        if (ch == '.') return 3;
        return -1;
    }
    public boolean isNumeric(char[] str) { 
        // 8个状态, 5种操作  => 为了
        int[][] automaton = {{1, 2, -1, 8},
                            {-1, 2, -1, 8}, 
                            {-1, 2, 5, 3},
                            {-1, 4, 5, -1},
                            {-1, 4, 5 , -1},
                            {6, 7, -1, -1},
                            {-1, 7, -1, -1},
                            {-1, 7, -1, -1},
                            {-1, 9, -1, -1},
                            {-1, 9, 5, -1}};
        int states = 0;
        for (int i = 0; i < str.length; i++) {
            int trans = op(str[i]);
            if (trans == -1) return false;
            states = automaton[states][trans];
            if (states == -1) return false;
        }
        return (states == 2 || states == 3 || states == 4 || states == 7 || states == 9);
    }

    public static void main(String[] args) {
        char[] str = {'-', '1', '0', '0', 'E', '-', '6'};
        System.out.println(P20NumericStrings.isNumeric(str));
    }
}
