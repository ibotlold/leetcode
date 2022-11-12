import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(1);
        solution.addNum(4);
        solution.findMedian();
        solution.addNum(3);
        solution.addNum(2);
        solution.findMedian();
    }
}

class MedianFinder {
    PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

    Integer midValue;
    public MedianFinder() {

    }

    public void addNum(int num) {
        PriorityQueue<Integer> next = null;
        if (midValue == null) {
            if (leftQueue.size() > 0 && num < leftQueue.peek()) next = leftQueue;
            if (rightQueue.size() > 0 && num > rightQueue.peek()) next = rightQueue;
            if (next != null) {
                midValue = next.poll();
                next.offer(num);
                return;
            }
            midValue = num;
            return;
        }
        if (midValue > num) {
            rightQueue.offer(midValue);
            leftQueue.offer(num);
        } else {
            leftQueue.offer(midValue);
            rightQueue.offer(num);
        }
        midValue = null;
    }

    public double findMedian() {
        if (midValue != null) return midValue;
        return (leftQueue.peek() + rightQueue.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */