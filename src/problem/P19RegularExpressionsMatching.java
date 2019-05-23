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
        int strIndex = 0, patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length &&  patternIndex == pattern.length) return true;
        /*
        当第一个字符串不空，而第二个字符串空了，返回false
        （因为这样，就无法匹配成功了,而如果第一个字符串空了，第二个字符串非空，还是可能匹配成
         功的，比如第二个字符串是“a*a*a*a*”,由于‘*’之前的元素可以出现0次，所以有可能匹配成功）
         */
        if (strIndex != str.length &&  patternIndex == pattern.length) return false;
        /*
        之后就开始匹配第一个字符，这里有两种可能：匹配成功或匹配失败。但考虑到pattern
        下一个字符可能是‘*’， 这里我们分两种情况讨论：pattern下一个字符为‘*’或
        不为‘*’：
              1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
                匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
                “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
                当前字符为‘.’,同时str的当前字符不为‘\0’。
         */
        if ((patternIndex+1 < pattern.length) && pattern[patternIndex+1] == '*') { // 而当模式中的第二个字符是“*”时：
            /*
            如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
                1、模式后移2字符，相当于x*被忽略； 匹配0个
                2、字符串后移1字符，模式后移2字符； 匹配1个
                3、字符串后移1字符，模式不变，即继续匹配字符下一位；匹配多位
            如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
             */
            if (strIndex != str.length && (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex])) {
                return matchCore(str, strIndex, pattern, patternIndex+2)
                        || matchCore(str, strIndex+1, pattern, patternIndex+2)
                        || matchCore(str, strIndex+1, pattern, patternIndex);
            } else {
                // str当前字符不变，pattern当前字符后移两位，跳过这个‘*’符号；
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }
        // 模式的第二个字符串不是 *
        if (strIndex != str.length && (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex]))
            return matchCore(str, strIndex+1, pattern, patternIndex+1);

        return false;
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a'};
        char[] pattern = new char[]{'.'};
        String s = "0123";
        // System.out.println(s.substring(1));
        // System.out.println(pattern);
        System.out.println(P19RegularExpressionsMatching.match(str, pattern));
    }
}
