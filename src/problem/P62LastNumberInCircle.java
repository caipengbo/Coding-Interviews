package problem;

import java.util.LinkedList;

/**
 * Title: 62. 圆圈中最后剩下的数字(约瑟夫环问题)
 * Desc: 0, 1, 2, n-1 这 n 个数字排成一个圆圈，从数字0开始，每次从这个圆圈删除第m个数字，求这个圆圈里剩下的最后一个数字
 * Created by Myth on 7/12/2019
 */
public class P62LastNumberInCircle {
    // 解法1，使用环形链表
    public int LastRemaining(int n, int m) {
        if (n <=0 || m <= 0) return -1;
        LinkedList<Integer> circle = new LinkedList<>();
        // 初始化
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int size = circle.size();
        int index = -1;  // 注意下标的开始
        // 难点如何模拟环？？？使用取余
        while (size > 1) {
            index = (index + m) % size;
            circle.remove(index--);
            size--;
        }
        // 另外一种思路：将删除的元素置为-1，然后设置一个指针，如果该位置为-1，就跳过
        return circle.get(0);
    }
    
    
    public static void main(String[] args) {
        P62LastNumberInCircle p62 = new P62LastNumberInCircle();
        System.out.println(p62.LastRemaining(5, 3));
    }
}
