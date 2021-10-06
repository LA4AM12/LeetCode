package Offer;

import java.util.Deque;
import java.util.LinkedList;

//剑指offer 30

class Solution30 {
    Deque<Integer> stack1,stack2;
    /**
     * initialize your data structure here.
     */
    public Solution30() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek())
            stack2.push(x);
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek()))
            stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
