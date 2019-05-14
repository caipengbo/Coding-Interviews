package problem;

/**
 * Title: 打印1到最大的n位数
 * Desc: 输入数字n, 按顺序打印出从1到最大的n位十进制数，比如数3，则打印出1，2,3….一直到3位数最大即999
 * Created by Myth on 5/14/2019
 */
public class P17Print1ToMaxNDigits {
    // 解法1：字符串模拟大数加1
    public static void solution1(int n) {
        if (n <= 0) return;
        // n 位 0 串
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            s = s.append('0');
        }
        // 加1
        while (increased(s)) {
            // 打印
            print(s);
        }
    }
    public static Boolean increased(StringBuffer s) {
        int len = s.length();
        // 进位
        int carry = 0;
        int sumVal = 0;
        for (int i = len - 1; i >=0; i--) {
            if (i == len - 1) {
                sumVal = s.charAt(i) - '0' + 1;
            } else {
                sumVal = s.charAt(i) - '0' + carry;
            }
            if (sumVal == 10) {
                carry = 1;
                s.setCharAt(i, '0');
            } else {
                carry = 0;
                s.setCharAt(i, (char) ('0'+sumVal));
            }
        }
        // 最后进位还是1的话，说明超过位数了 return false
        return carry == 0;
    }
    public static void print(StringBuffer s) {
        int len = s.length();
        int pos = len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                pos = i;
                break;
            }
        }
        if (pos == len) {
            // System.out.println("0");
            return;
        }
        System.out.println(s.substring(pos, len));
    }
    // 解法2：全排列问题
    public static void solution2(int n) {
        if (n <= 0) return;
        // n 位 0 串
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            s = s.append('0');
        }
        recursive(s, 0);
    }
    public static void recursive(StringBuffer s, int index) {
        if (index == s.length()) {
            print(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            s.setCharAt(index, (char)('0'+i));
            recursive(s, index + 1);
        }
    }

    public static void main(String[] args) {
        P17Print1ToMaxNDigits.solution2(2);
    }
}
