package problem;

/**
 * Title: 53.3 递增数组中数值与下标相等的元素
 * Desc: 一个单调递增数组的每个元素都是整数 并且唯一，找到任意一个数值等于其下标的元素
 * 例如： {-3, -1, 1, 3, 5}, 数字 3和它的下标相等
 * Created by Myth on 6/29/2019
 */
public class P53_3InterIdenticalToInex {
    // 还是二分查找的思想
    // arr[i] > i, 那么：arr[i+k] > a[i]+k > i +k (arr中的元素全部都是整数)
    // 意味着 下标 i, arr[i] > i 那么其右边的值都大于其下标（对于元素为整数而言，不是整数不成立）
    public int find(int[] arr) {
        if (arr == null) return -1;
        int len = arr.length;
        if (len == 0) return -1;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left+right) >> 1;
            if (arr[mid] == mid) {
                return mid;
            }
            if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P53_3InterIdenticalToInex p53 = new P53_3InterIdenticalToInex();
        int[] arr1 = {-3, -1, 1, 3, 5};
        int[] arr2 = {-3, -1, 1, 0, 5};
        int[] arr3 = {0};
        int[] arr4 = {1};
        int[] arr5 = {0, -1, 1, 0, 5};
        int[] arr6 = {0, -1, 1, 0, 4};
        System.out.println(p53.find(arr1));
        System.out.println(p53.find(arr2));
        System.out.println(p53.find(arr3));
        System.out.println(p53.find(arr4));
        System.out.println(p53.find(arr5));
        System.out.println(p53.find(arr6));
    }
}
