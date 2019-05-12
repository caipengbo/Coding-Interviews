package problem;

import java.util.*;

/**
 * Title: 15题 二进制位中 1 的个数
 * Desc: 统计一个整数，二进制表示后，1的个数
 * Created by Myth on 5/12/2019
 */
public class P15NumberOf1InBinary {
    // 解法1：Shift, 每次 n 右移一位，与 1 做 & 操作，便可以依次统计最后一位是否为 1
    public static int solution1(int n) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n&1);
            num += n & 1;
            n = n >>> 1;  // 注意不能使用 >> 移位，因为java的 >> 移位对于负数会补1，而>>> 移位会补0
        }
        Collections.reverse(list);
        System.out.println(list);
        return num;
    }
    // 解法2： 1每次左移 1位（左移32次）, 和 n 做 & 操作 (如果没有 >>> 操作的话，就使用这种方法)
    public static int solution2(int n) {
        int num = 0;
        int m = 1;
        List<Integer> list = new ArrayList<>();
        while (m != 0) {
            if ((n & m) != 0) {
                num++;
                list.add(1);
            } else {
                list.add(0);
            }
            m = m << 1;
        }
        Collections.reverse(list);
        System.out.println(list);
        return num;
    }

    // 解法3：把整数 n 减去1，再和原来的整数 n 做 & 运算，会把整数最右边的 1 变成 0（这个技巧在很多地方会使用）
    public static int solution3(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n = (n - 1) & n;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(P15NumberOf1InBinary.solution3(0));
    }
}
