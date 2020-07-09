package problem;

/**
 * Title: 53.2 求0 —— n中缺失的数字
 * Desc: 长度位 n的数组递增排序数组，所有数字都是唯一的，且都在0- n范围内，求缺失的那个数字
 * Created by Myth on 6/29/2019
 */
public class P53_2MissingNumber {

    // LeetCode第二遍
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length-1, m;
        while (l < r) {
            m = l + (r - l >> 1);
            if (nums[m] > m) r = m; // 第一个值大于下标
            else l = m + 1;
        }
        return nums[l] > l ? l : l+1;
    }

    // 找到第一个值与下标不相等的元素
    // 二分查找(非递归写法)
    public int solution(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left+right) >> 1;
            if (array[mid] != mid) {
                if (mid == 0 || array[mid-1] == (mid-1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    

    public static void main(String[] args) {
        P53_2MissingNumber p53 = new P53_2MissingNumber();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 1, 3, 4, 5};
        int[] arr3 = {0, 1, 2, 3, 4};
        int[] arr4 = {0};
        System.out.println(p53.missingNumber(arr1));
        System.out.println(p53.missingNumber(arr2));
        System.out.println(p53.missingNumber(arr3));
        System.out.println(p53.missingNumber(arr4));
    }
}
