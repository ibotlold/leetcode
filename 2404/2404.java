import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> evenNumbers = new HashMap<>();
        int maxFrequency = 0;
        ArrayList<Integer> maxFrequentNumbers = new ArrayList<Integer>();
        for (int element : nums) {
            Integer number = element;
            if (element % 2 != 0) continue;
            if (!evenNumbers.containsKey(number)) evenNumbers.put(number, 0);
            int frequency = evenNumbers.get(number) + 1;
            evenNumbers.put(number, frequency);
            if (maxFrequency < frequency) {
                maxFrequency = frequency;
                maxFrequentNumbers.clear();
            }
            if (maxFrequency == frequency) {
                maxFrequentNumbers.add(number);
            }
        }
        if (maxFrequency == 0) return -1;
        return Collections.min(maxFrequentNumbers);
    }
}