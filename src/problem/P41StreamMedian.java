package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: 41. 数据流中的中位数
 * Desc: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * Created by Myth on 6/18/2019
 */
public class P41StreamMedian {
    private PriorityQueue<Integer> minHeap = new PriorityQueue();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    private int count = 0;

    public void Insert(Integer num) {
        if ((count & 1 ) == 1) { // 奇数，新数据插入最大堆（左侧）
            // 新数据和最小堆的最小数字对比，比它大；最小堆的最小值插入最大堆，新数据插到最小堆
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                Integer minVal = minHeap.poll();
                maxHeap.add(minVal);
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else { // 偶数，新数据插入最小堆（右侧）
            // 新数据和最大堆的最大数字对比，比它小；最大堆的最大值插入最小堆，新数据插到最大堆
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                Integer maxVal = maxHeap.poll();
                minHeap.add(maxVal);
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        count++;
    }
    public void Insert2(Integer num) {
        if ((count & 1 ) == 1) { // 奇数，新数据插入最大堆（左侧）
            // 新数据和最小堆的最小数字对比，比它大；最小堆的最小值插入最大堆，新数据插到最小堆
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else { // 偶数，新数据插入最小堆（右侧）
            // 新数据和最大堆的最大数字对比，比它小；最大堆的最大值插入最小堆，新数据插到最大堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        count++;
    }
    // 注意数目不同时，中位数如何去求！！
    public Double GetMedian() {
        Double result;
        if((count & 1) == 1)
            result = Double.valueOf(minHeap.peek());
        else
            result = (minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,4,1,6,7,0,8};
        P41StreamMedian p41 = new P41StreamMedian();
        for (int i = 0; i < arr.length; i++) {
            p41.Insert(arr[i]);
        }
        System.out.println(p41.GetMedian());

    }
}
