package problem;

/**
 * Title: 42. 连续子数组的最大和
 * Desc: 计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * {1,-2,3,10,-4,7,2,-5} 最大子数组为 {3,10,-4,7,2} = 18
 * 给一个数组，返回它的最大连续子序列的和
 * Created by Myth on 6/19/2019
 */
public class P42GreatestSumOfSubarrays {
    // 解法1：非动态规划解法
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null) return 0;
        int len = array.length;
        if (len == 0) return 0;
        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < len; i++) {

            curSum += array[i];
            // 前面加的比当前数字还要小，抛弃前面的，累加从当前数字开始
            if (curSum < array[i]) {
                curSum = array[i];
            }
            // 也就是说 直接看 当前和 是否大于 maxSum 就行了
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
    // 解法2：TODO 动态规划解法
    public int findGreatestSumOfSubArray2(int[] array) {
        return 0;
    }

    public static void main(String[] args) {
        P42GreatestSumOfSubarrays p42 = new P42GreatestSumOfSubarrays();
        int[] arr = {1,-2,3,10,-4,7,2,-5}; // 18
        int[] arr2 = {6,-3,-2,7,-15,1,2,2}; // 8
        int[] arr3 = {-2,-8,-1,-5,-9}; // -1
        int[] arr4 = {2,8,1,5,9}; // 25
        System.out.println(p42.findGreatestSumOfSubArray(arr));
        System.out.println(p42.findGreatestSumOfSubArray(arr2));
        System.out.println(p42.findGreatestSumOfSubArray(arr3));
        System.out.println(p42.findGreatestSumOfSubArray(arr4));
    }
}
