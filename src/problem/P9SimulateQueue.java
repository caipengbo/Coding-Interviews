package problem;

import java.util.Stack;

/**
 * Title: 使用两个栈模拟队列
 * Desc: 
 * Created by Myth-PC on 28/01/2020 in VSCode
 */
public class P9SimulateQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}