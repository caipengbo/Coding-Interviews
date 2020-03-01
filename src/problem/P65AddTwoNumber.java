package problem;

/**
 * Title: 65. 不用加减乘除做加法
 * Desc: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * Created by Myth on 7/14/2019
 */
public class P65AddTwoNumber {
    // 使用位运算

    //首先看十进制是如何做的： 5+7=12，三步走
    //第一步：相加各位的值，不算进位，得到2。
    //第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
    //
    //第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
    //
    //同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111
    // 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
    //
    //第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
    //
    //第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
    //     继续重复上述两步：1000^100 = 1100，进位值为0时，跳出循环，1100为最终结果。
    public int Add(int num1,int num2) {
        int a = (num1 ^ num2);
        int b = (num1 & num2) << 1;
        while (b != 0) {
            a = (a ^ b);
            b = ((a & b) << 1);
        }
        return a;
    }
    public int Add2(int num1,int num2) {
        int temp;
        while (num2 != 0) {
            temp = (num1 ^ num2);
            num2 = ((num1 & num2) << 1);
            num1 = temp;
        }
        return num1;
    }
    // 第二遍
    public int add(int a, int b) {
        int xor;
        while (a != 0) {
            xor = a ^ b;
            a = (a & b) << 1;
            b = xor;
        }
        return b;
    }

    public static void main(String[] args) {
        P65AddTwoNumber p65 = new P65AddTwoNumber();
        System.out.println(p65.Add(111, 899));
    }
}
