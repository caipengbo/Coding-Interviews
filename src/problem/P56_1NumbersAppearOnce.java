package problem;

/**
 * Title: 56.1 数组中只出现一次的 两 个数字
 * Desc: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by Myth on 7/2/2019
 */
public class P56_1NumbersAppearOnce {
    // 这道题是对异或用法的考察
    //num1,num2分别为长度为1的数组。传出参数(Java中没有引用类型，所以就是有数组作为传出参数！)
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 求异或
        int orVal = 0;
        for (int i = 0; i < array.length; i++) {
            orVal ^= array[i];
        }
        // 找到两个数字不同的 位(异或结果第一个为 1 的数字)
        int index = findFirstBitOf1(orVal);
        // 根据这个 位 将数字分成两组
        // 求着两组数字里面的只出现一次的值（异或方法）
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    private int findFirstBitOf1(int orVal) {
        int index = 0;
        while ((orVal & 1) == 0 && index < 32) {
            orVal = orVal >> 1;
            index++;
        }
        return index;
    }
    private boolean isBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int a = 0;
        System.out.println(3^0);
    }
}
