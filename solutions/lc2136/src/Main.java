import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        new Solution().earliestFullBloom(new int[]{4, 3, 1}, new int[]{3, 1, 2});
//        [27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2]
//        [26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12]
//        new Solution().earliestFullBloom(new int[]{27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2}, new int[]{26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12});
    }
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        final int plantNumber = plantTime.length;
        ArrayList<Integer> sequence = new ArrayList<>(plantNumber);
        for (int i = 0; i < plantNumber; i++) {
            sequence.add(i);
        }
        Comparator<Integer> comparator = (a, b) -> {
            if (growTime[a] > growTime[b]) return 1;
            if (growTime[a] < growTime[b]) return -1;
            return 0;
        };
        sequence.sort(comparator.reversed());
        int days = 0;
        int daysRemains = 0;
        for (int i = 0; i < plantNumber; i++) {
            int nextBusyDays = plantTime[sequence.get(i)];
            days += nextBusyDays;
            if (nextBusyDays > daysRemains) daysRemains = 0;
            else daysRemains -=nextBusyDays;
            int bloomDays = growTime[sequence.get(i)];
            if (bloomDays > daysRemains) daysRemains = bloomDays;
        }
        return days + daysRemains;
    }
}