package LCJZSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LCJz041 {

    class MedianFinder {

        //大顶堆存储较小的一半
        PriorityQueue<Integer> maxHeap ;
        //小顶堆存储较大的一半
        PriorityQueue<Integer> minHeap ;
        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((o1, o2) ->  o2-o1);
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (minHeap.size()-1>maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek()+minHeap.peek())/2.0:minHeap.peek();
        }
    }
}
