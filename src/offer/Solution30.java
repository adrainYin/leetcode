package offer;

import java.util.Stack;

public class Solution30 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        //为空直接进栈
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            int currMin = stack2.peek();
            stack2.push(Math.min(currMin, node));
        }
    }

    public void pop() {
        if (!stack1.isEmpty() && !stack2.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
