package problem;

import java.util.*;

/**
 * Title: 59.1 滑动窗口的最大值
 * Desc:
 * Created by Myth on 7/6/2019
 */
public class P59_1_2MaxInQueue {
    // 题目一： 滑动窗口的最大值
    // 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    // 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
    // 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    // {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
    // {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    // 使用 队列
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            Deque<Integer> deque = new ArrayDeque<>();
            // 窗口未满的时候
            for (int i = 0; i < size; i++) {
                while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }

            for (int i = size; i < num.length; i++) {
                ret.add(num[deque.getFirst()]);
                // 大于尾部元素，去除尾部元素
                while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                    deque.removeLast();
                }
                // 当前下标与队列头的下标之差大于等于滑动窗口的大小的时候 ，去除队列头
                if (!deque.isEmpty() && deque.getFirst() <= (i-size)) {
                    deque.removeFirst();
                }
                deque.addLast(i);
            }
            ret.add(num[deque.getFirst()]);
        }
        return ret;
    }
    // 题目二： 求队列的最大值，实现 max  push_back  pop_front 函数（模仿上面题目的思路）
    private Queue<Integer> dataDeque = new LinkedList<>();
    private Deque<Integer> maxValueDeque = new ArrayDeque<>();
    public void pushBack(Integer num) {
        while (!maxValueDeque.isEmpty() && num > maxValueDeque.getLast()) {
            maxValueDeque.removeLast();
        }
        dataDeque.add(num);
        maxValueDeque.addLast(num);
    }
    public void popFront() throws Exception {
        if (dataDeque.isEmpty()) throw new Exception("队列为空");
        if (dataDeque.peek().equals(maxValueDeque.getFirst())) maxValueDeque.removeFirst();
        dataDeque.poll();
    }
    public Integer max() throws Exception {
        if (dataDeque.isEmpty()) throw new Exception("队列为空");
        return maxValueDeque.getFirst();
    }

    public static void main(String[] args) throws Exception {
        P59_1_2MaxInQueue p59 = new P59_1_2MaxInQueue();
        p59.pushBack(2);
        p59.pushBack(3);
        p59.pushBack(6);
        p59.pushBack(4);
        p59.pushBack(4);
        p59.pushBack(2);
        // p59.pushBack(6);
        p59.popFront();
        p59.popFront();
        p59.popFront();
        p59.popFront();
        System.out.println(p59.max());

    }
}
