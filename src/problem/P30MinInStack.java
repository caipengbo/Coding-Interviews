package problem;

import java.util.Stack;

/**
 * Title: 30. 包含min函数的栈
 * Desc: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数( 时间复杂度应为 O(1) )。
 * Created by Myth on 6/3/2019
 */
public class P30MinInStack {
    // 思路：创建一个辅助栈，用来保存每个位置的最小元素，push的时候辅助栈也push，pop的时候，辅助栈也pop
    private Stack<Integer> auxiliaryStack = new Stack<>();
    private Stack<Integer> dataStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (auxiliaryStack.empty()) {
            auxiliaryStack.push(node);
        } else {
            if (node < auxiliaryStack.peek()) {
                auxiliaryStack.push(node);
            } else {
                auxiliaryStack.push(auxiliaryStack.peek());
            }
        }
    }

    public void pop() {
        dataStack.pop();
        auxiliaryStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return auxiliaryStack.peek();
    }
}
