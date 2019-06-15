package problem;

/**
 * Title: 39. 数组中出现次数超过一半的数字
 * Desc: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * Created by Myth on 6/15/2019
 */
public class P39MoreThanHalfNumber {
    // 使用快排的分割函数
    // 快排（从小到大）：找基准，左边比基准小；右边比基准大，基准摆到正确的位置（一次分割，返回基准的正确位置 index）。
    // 递归接着分割（基准 index 的）左右两边，这是一次分割
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 实现1： 一个位置一个位置（i记录位置）的去填写比 pivot 小的数（j去找位置）
    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i+1, high);
        return i+1;
    }
    // 实现2：两个哨兵指针
    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi] and return the index j.
    private int partition2(int[] a, int lo, int hi) {
        // 注意初始
        int i = lo;  // i先自增
        int j = hi + 1; // j先自减，所以加了1
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while (a[++i] < v) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (v < a[--j]) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }
            // check if pointers cross
            if (i >= j) break;
            swap(a, i, j);
        }
        // put partitioning item v at a[j]
        swap(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    // 循环 寻找 等于 middle 的 pivot
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if (len < 1) return 0;
        int mid = len >> 1;
        int low = 0, high = len - 1;
        int pivot = partition(array, low, high);
        while (pivot != mid) {
            if (pivot > mid) {
                high = pivot - 1;
            } else {
                low = low + 1;
            }
            pivot = partition(array, low, high);
        }
        // 是否是大多数元素
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == array[pivot]) count++;
        }
        if (count > mid) return array[pivot];
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        P39MoreThanHalfNumber p39 = new P39MoreThanHalfNumber();
        int res = p39.MoreThanHalfNum_Solution(arr);
        System.out.println(res);
    }

}
