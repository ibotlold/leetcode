import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution minimumNumberGroups = new Solution();
        int[][] intervals = {{5,10}, {6,8}, {1,5}, {2,3}, {1,10}};
//        int[][] intervals = {{441459,446342},{801308,840640},{871890,963447},{228525,336985},{807945,946787},{479815,507766},{693292,944029},{751962,821744}};
        minimumNumberGroups.minGroups(intervals);
    }
}

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


// class Solution {
//     public int minGroups(int[][] intervals) {
//         int result = 1;
//         int mask = 0;
//         for (int i = 0; i < intervals.length - 1; i++) {
//             int intersections = 0;
//             for (int j = i + 1; j < intervals.length; j++) {
//                 if ((mask & (1 << i)) != 0) continue;
//                 if (intersect(intervals[i], intervals[j])) intersections++;
//                 mask = mask | (1 << i);
//             }
//             result = Math.max(result, intersections);
//         }
//         return result;
//     }

//     boolean intersect(int[] a, int[] b) {
//         if (a[0] > b[1]) return false;
//         if (a[1] < b[0]) return false;
//         return true;
//     }
// }

// class Solution {
//     public int minGroups(int[][] intervals) {
//         int result = 1;
//         int mask = 0;
//         for (int i = 0; i < intervals.length - 1; i++) {
//             int intersections = 0;
//             for (int j = i + 1; j < intervals.length; j++) {
//                 if ((mask & (1 << i)) != 0) continue;
//                 if (intersect(intervals[i], intervals[j])) intersections++;
//                 mask = mask | (1 << i);
//             }
//             result = Math.max(result, intersections);
//         }
//         return result;
//     }

//     boolean intersect(int[] a, int[] b) {
//         if (a[0] > b[1]) return false;
//         if (a[1] < b[0]) return false;
//         return true;
//     }
// }