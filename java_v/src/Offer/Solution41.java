package Offer;

import java.util.PriorityQueue;

class Solution41 {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public Solution41() {
        //小根堆
        small = new PriorityQueue<>();

        //大根堆
        large = new PriorityQueue<>(((o1, o2) -> o2-o1));
    }

    //维持两个堆的元素差不超过1
    //大根堆的最大元素 <= 小根堆的最小元素
    public void addNum(int num) {
        if (large.size() > small.size()){
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        else if (large.size() > small.size())
            return large.peek();
        else
            return (small.peek() + large.peek()) / 2.0;
    }
}
