package Offer;

//剑指offer 09

import java.util.Deque;
import java.util.LinkedList;

public class Solution09 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public Solution09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty())
                return -1;
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
