package Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
// 剑指 Offer 59 - II. 队列的最大值

class MaxQueue {
    //普通队列
    private Queue<Integer> queue;
    //单调队列
    private Deque<Integer> queue1;

    public MaxQueue() {
        queue = new LinkedList<>();
        queue1 = new LinkedList<>();
    }

    public int max_value() {

        return queue1.peek() == null?-1:queue1.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (queue1.peekLast()!=null && queue1.peekLast()  < value){
            queue1.removeLast();
        }
        queue1.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int value = queue.poll();
        if (value == queue1.peek())
            queue1.poll();
        return value;
    }
}