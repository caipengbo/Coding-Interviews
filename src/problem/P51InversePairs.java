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
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        P51InversePairs p51 = new P51InversePairs();
        p51.test(a);
        System.out.println(Arrays.toString(a));
    }
}
