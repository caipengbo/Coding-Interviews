package problem;

/**
 * Title: 正则表达式匹配
 * Desc: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * Created by Myth on 5/18/2019
 */
public class P19RegularExpressionsMatching {
    // 难点：已知状态机，如何确定前面的状态
    // 使用递归，模拟状态（每一个状态就是递归函数的不同参数）的转移
    public static boolean match(char[] str, char[] pattern) { // OJ要求使用字符数组作为参数
        if (str == null || pattern == null) return false;

        String strObj = new String(str);
        String patternObj = new String(pattern);

        return matchCore(strObj, patternObj);
    }
    public static boolean matchCore(String str, String pattern) {
        if ("".equals(str) &&  "".equals(pattern)) return true;
        // "",".*" 用例错误
        if ((!"".equals(str) && "".equals(pattern)) || ("".equals(str) && !"".equals(pattern))) return false;

        if ((pattern.charAt(0) == '.' && !"".equals(str)) || str.charAt(0) == pattern.charAt(0)) {
            return matchCore(str.substring(1), pattern.substring(1));
        }
        // 第二个字符时 "*"
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            if ((pattern.charAt(0) == '.' && !"".equals(str)) || str.charAt(0) == pattern.charAt(0)) {
                return matchCore(str.substring(1), pattern.substring(2))
                        || matchCore(str.substring(1), pattern)
                        || matchCore(str, pattern.substring(2)) ;
            } else {
                return matchCore(str, pattern.substring(2));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'a', 'a'};
        char[] pattern = new char[]{'a', 'a', '.', 'a'};
        String s = "0123";
        // System.out.println(s.substring(1));
        // System.out.println(pattern);
        System.out.println(P19RegularExpressionsMatching.match(str, pattern));
    }
}
