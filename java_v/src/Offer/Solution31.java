package Offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pos = 0;

        for (int i : pushed) {
            stack.push(i);

            while (!stack.isEmpty() && stack.peek() == popped[pos]) {
                pos++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
