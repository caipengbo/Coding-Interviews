package problem;

/**
 * Title: 56.2 数组中唯一只出现一次的数字
 * Desc:  一个整型数组里除了两个数字之外，其他的数字都出现了三次。请写程序找出这个只出现一次的数字。
 * Created by Myth on 7/3/2019
 */
public class P56_2NumberAppearingOnce {
    // 还是位运算的思路，每一位都相加起来，如果某一位能被 3 整除那么只出现一次的那个数对应的
    // 这一位就是0， 否则的话是 1
    //  如何求得每一位？ 掩码！
    public int FindNumsAppearOnce(int [] array) {
        if (array == null) return -1;
        int len = array.length;
        if (len == 0) return -1;
        // 默认是0
        int[] bitSum = new int[32];
        int mask; // 掩码
        for (int i = 0; i < len; i++) {
            mask = 1;
            for (int j = 31; j > 0; j--) {
                bitSum[j] += (array[i] & mask);
                mask = mask << 1;
            }
        }
        int ret = 0;
        // 注意这种方法只适合 正数 哦
        for (int i = 0; i < 32; i++) {
            if (bitSum[i] % 3 == 0) ret = ret * 2;
            else ret = 1 + ret * 2;
        }
        return ret;
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 注意此处，结果可不等于 1 
                if ((num & (1 << i)) != 0) count++;
                // if ((num & (1 << i)) == 1) count++;
            }
            if (count % 3 != 0) ret += (1 << i);
        }
        return ret; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 3, 4, 4, 4, -1};
        P56_2NumberAppearingOnce p56 = new P56_2NumberAppearingOnce();
        System.out.println(p56.FindNumsAppearOnce(arr));
    }
}
