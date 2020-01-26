package problem;

import java.util.*;

/**
 * Title: 40. 最小的K个数
 * Desc: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 解法1： partition
 * 解法2： 最大堆
 * Created by Myth on 6/17/2019
 */
public class P40KLeastNumber {
    // 解法 1：继续使用 39题的 partition 思路, 位于 index = k 左边的是比 k 小的那些数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] array, int k) {
        int len = array.length;
        ArrayList<Integer> ret = new ArrayList<>();
        if (k <= 0 || len < k) return ret;
        int low = 0, high = len - 1;
        int pivot = partition(array, low, high);
        k = k - 1;
        while (pivot != k) {
            if (pivot > k) {
                high = pivot - 1;
            } else {
                low = low + 1;
            }
            pivot = partition(array, low, high);
        }
        for (int i = 0; i <= k; i++) {
            ret.add(array[i]);
        }
        return ret;
    }
    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int i = begin+1, j = end;
        while (true) {
            while (i < end && arr[i] < pivot) {
                i++;
            }
            while (j > begin && arr[j] > pivot) {
                j--;
            }
            if (i >= j) break;
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // swap
        int temp = arr[begin];
        arr[begin] = arr[j];
        arr[j] = temp;
        return j;
    }
    // 使用堆（类似于一个容器），适合大数据，不用讲全部数据读入内存
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] array, int k) {
        int len = array.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (k <= 0 || len < k) return result;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
        for (int value : array) {
            if (maxHeap.size() < k) {
                maxHeap.add(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.poll();
                maxHeap.add(value);
            }
        }

        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        int[] arr2 = {8,2,3,6,5,1,7,9};
        P40KLeastNumber p40 = new P40KLeastNumber();
        // ArrayList<Integer> ret = p40.GetLeastNumbers_Solution3(arr2, 2);
        // System.out.println(ret.toString());
        // p40.useHeap();
    }

}
