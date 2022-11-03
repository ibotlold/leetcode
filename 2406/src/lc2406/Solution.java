package lc2406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval :
                intervals) {
            if (!queue.isEmpty() && queue.peek() < interval[0]) queue.remove();
            queue.offer(interval[1]);
        }
        return queue.size();
    }
}
