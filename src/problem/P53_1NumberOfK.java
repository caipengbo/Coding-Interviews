package problem;

/**
 * Title: 53.1 数字在排序数组中出现的次数
 * Desc: 统计一个数字在排序数组中出现的次数。
 * Created by Myth on 6/28/2019
 */
public class P53_1NumberOfK {
    // 使用二分查找
    public int GetNumberOfK(int[] array , int k) {
        int len = array.length;
        if (len == 0) return 0;
        int first = findFirst(array, 0, len-1, k);
        int last = findLast(array, 0, len-1, k);
        return last - first + 1;
    }
    private int findFirst(int[] array, int start, int end, int k) {
        // System.out.println(start + " " + end);
        if (start >= end) {
            if (array[start] == k) return start;
            else return -1;
        }
        int mid = (start+end) >> 1;
        if (k < array[mid]) {
            return findFirst(array, start, mid, k);
        } else if (k > array[mid]) {
            return findFirst(array, mid+1, end, k);
        } else if (k == array[mid]) {
            if (mid != 0 && k == array[mid-1]) {
                return findFirst(array, start, mid-1, k);
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findLast(int[] array, int start, int end, int k) {
        // System.out.println(start + " " + end);
        if (start >= end) {
            if (array[start] == k) return start;
            else return -2;
        }
        int mid = (start+end) >> 1;
        if (k < array[mid]) {
            return findLast(array, start, mid, k);
        } else if (k > array[mid]) {
            return findLast(array, mid+1, end, k);
        } else if (k == array[mid]) {
            if (mid != end && k == array[mid+1]) {
                return findLast(array, mid+1, end, k);
            } else {
                return mid;
            }
        }
        return -2;
    }

    public static void main(String[] args) {
        P53_1NumberOfK p53 = new P53_1NumberOfK();
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 4, 5};
        System.out.println(p53.GetNumberOfK(arr, 5));
        // System.out.println((0+1)>>1);
    }
}
