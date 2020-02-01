package problem;

import java.util.Collections;

/**
 * Title: 58.1 翻转单词  58.2 左旋转字符串
 * Desc:
 * Created by Myth on 7/5/2019
 */
public class P58_1_2ReverseString {
    // 输入一个英文句子，翻转句子中英语单词的顺序(标点符号和普通字母一样处理),例如： I am a student. -> student. a am I
    // 方法 1： 翻转两次：翻转全部句子，再次翻转每个单词,在一个串上操作
    // 方法 2： split， 然后入栈，再出栈, 拼装
    private void reverse(char[] sentence, int begin, int end) {
        if (end >= sentence.length) return;
        while (begin < end) {
            // swap(sentence[begin], sentence[end])
            sentence[begin] = (char)(sentence[begin] ^ sentence[end]);
            sentence[end] = (char)(sentence[end] ^ sentence[begin]);
            sentence[begin] = (char)(sentence[end] ^ sentence[begin]);
            begin++;
            end--;
        }
    }
    public String reverseWord(String sentence) {
        int len = sentence.length();
        if (len == 0) return "";
        char[] sentenceChars = sentence.toCharArray();
        int begin = 0, end = len-1;
        // 翻转整个句子
        reverse(sentenceChars, begin, end);
        System.out.println(String.valueOf(sentenceChars));
        begin = 0;
        end = 0;
        // Point: 再次翻转每个单词（两个指针来寻找单词的起始位置）
        while (end < len) {
            if (sentenceChars[begin] == ' ') {
                begin++;
                end++;
            } else if (sentenceChars[end] == ' ') { // 注意边界的控制
                reverse(sentenceChars, begin, --end);
                begin = ++end;
            } else {
                end++;
            }
        }
        return String.valueOf(sentenceChars);
    }
    // 
    public String reverseWord2(String sentence) {
        int len = sentence.length();
        if (len == 0) return "";
        char[] sentenceChars = sentence.toCharArray();
        // 翻转整个句子
        reverse(sentenceChars, 0, len-1);
        int begin, end = 0;
        while (end < len && sentenceChars[end] == ' ') end++;
        begin = end;
        while (end < len) {
            if (sentenceChars[end] == ' ') {
                reverse(sentenceChars, begin, end-1);
                while (end < len && sentenceChars[end] == ' ') end++;
                begin = end;
            } else {
                end++;
            }
        }
        if (begin < len && end == len) reverse(sentenceChars, begin, end-1);
        return String.valueOf(sentenceChars);
    }

    // 题目二： 左旋转字符串
    // 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
    // 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
    // 简单方法：
    //        String left = str.substring(0, n);
    //        String right = str.substring(n, str.length());
    //        return right+left;
    // 翻转方法： 123456， 2
    // 分成两部分12|3456       各部分翻转21|6543， 翻转整个字符串  345612
    public String LeftRotateString(String str, int n) {
        if (str == null) return null;
        if (n > str.length()|| n < 1) return str;
        int begin = 0, end = n-1;
        char[] strChars = str.toCharArray();
        reverse(strChars, begin, end);
        reverse(strChars, end+1, str.length()-1);
        reverse(strChars, begin, str.length()-1);
        return String.valueOf(strChars);
    }

    public static void main(String[] args) {
        P58_1_2ReverseString p58 = new P58_1_2ReverseString();
        System.out.println(p58.reverseWord2(" I am a  student.  "));
        // System.out.println(p58.LeftRotateString("abcdefg", 2));
        // String s = "abc";
    }
}
