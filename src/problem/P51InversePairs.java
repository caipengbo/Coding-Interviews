package problem;

import java.util.Arrays;

/**
 * Title: 51. 数组中的逆序对
 * Desc: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *  输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出 P%1000000007
 * Created by Myth on 6/27/2019
 */
public class P51InversePairs {
    // 归并排序的思想
    public int InversePairs(int[] array) {
        if (array == null) return 0;
        int len = array.length;
        if (len == 0) return 0;
        int[] temp = array.clone();
        return inversePairsCore(array, temp, 0, len-1);
    }
    private int inversePairsCore(int[] array, int[] temp, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (end + start) / 2;
        // 注意为什么是temp和array交换了位置，因为这个时候，temp是有序的，而array是无序的
        int leftCount = inversePairsCore(temp, array, start, mid);
        int rightCount = inversePairsCore(temp, array, mid + 1, end);
        int count = 0;
        int p1 = mid;
        int p2 = end;
        int p3 = end;
        while (p1 >= start && p2 > mid) {
            if (array[p1] > array[p2]) {
                count += p2 - mid;
                if (count > 1000000007) {
                    count %= 1000000007;
                }
                temp[p3--] = array[p1--];
            } else {
                temp[p3--] = array[p2--];
            }
        }
        while (p1 >= start) {
            temp[p3--] = array[p1--];
        }
        while (p2 > mid) {
            temp[p3--] = array[p2--];
        }
        return (leftCount+rightCount+count) % 1000000007;
    }

    public void test(int[] arr) {
        arr[0] = 100;
    }

    // 第二遍
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return reversePairs(nums, 0, n-1);
    }
    public int reversePairs(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int count = 0;
        int m = (start + end) / 2;
        int[] copyArr = new int[nums.length];
        count += reversePairs(nums, start, m);
        count += reversePairs(nums, m+1, end);
        count += countPairs(nums, start, m, m+1, end, copyArr);
        return count;
    }
    private int countPairs(int[] nums, int start1, int end1, int start2, int end2, int[] copyArr) {
        if (start1 >= start2) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            copyArr[i] = nums[i];
        }        
        int i = start1;
        while (start1 <= end1 && start2 <= end2) {
            if (copyArr[start1] > copyArr[start2]) {
                count += end1 - start1 + 1;
                nums[i++] = copyArr[start2++];
            } else {
                nums[i++] = copyArr[start1++];
            }
        }
        while (start1 <= end1) nums[i++] = copyArr[start1++];
        while (start2 <= end2) nums[i++] = copyArr[start2++];
        return count;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        P51InversePairs p51 = new P51InversePairs();
        int[] nums0 = {7,5,6,4};
        int[] nums1 = {7,5,6};
        int[] nums2 = {7,5};
        int[] nums3 = {7};
        System.out.println(p51.reversePairs(nums0));
        System.out.println(p51.reversePairs(nums1));
        System.out.println(p51.reversePairs(nums2));
        System.out.println(p51.reversePairs(nums3));
    }
}
