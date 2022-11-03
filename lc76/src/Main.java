import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(new TwoPointers().minWindow("ADOBECODEBANC", "ABC"));
//        new TwoPointers().minWindow("a", "a");
    }

}

class Dp {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] indexes = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {

        }
        return "";
    }
}

class StringBuilders {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] matchIndexArray = new int[t.length()];
        ArrayList<StringBuilder> array = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j) && matchIndexArray[j] != 0) {
                    matchIndexArray[j] = i;
                    array.add(new StringBuilder().append(s.charAt(i)));
                }
            }
            for (int match :
                    matchIndexArray) {
                if (match == 0) continue;
            }

        }
        return "";
    }
}

class TwoPointers {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int startPointer = 0, endPointer = 0;
        int start = 0, minLength = Integer.MAX_VALUE;
        int counter = t.length();
        HashMap<Character, Integer> tCharFreq = new HashMap<>(t.length(),1);
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tCharFreq.put(key,tCharFreq.getOrDefault(key,0) + 1);
        }
        while (endPointer < s.length()) {
            char character = s.charAt(endPointer);
            Integer endCharFreq = tCharFreq.get(character);
            if (endCharFreq != null) {
                if (endCharFreq > 0) counter--;
                tCharFreq.put(character,endCharFreq - 1);
            }
            endPointer++;
            while (counter == 0) {
                if (minLength > endPointer - startPointer) {
                    minLength = endPointer - startPointer;
                    start = startPointer;
                }
                char beginChar = s.charAt(startPointer);
                Integer beginCharFreq = tCharFreq.get(beginChar);
                if (beginCharFreq != null) {
                    tCharFreq.put(beginChar, beginCharFreq + 1);
                    if (beginCharFreq + 1 > 0) counter++;
                }
                startPointer++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}

class TwoPointersFail {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        ArrayList<int[]> windows = new ArrayList<>(t.length());
        HashMap<Integer, Integer> matchIndexMap = new HashMap<>(t.length(), 1);

        int startPointer = 0, endPointer = 0;
        while (endPointer != s.length()) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(endPointer) == t.charAt(i)) {
                    if (matchIndexMap.get(i) != null) continue;
                    matchIndexMap.put(i,endPointer);
                    break;
                }
            }
            if (matchIndexMap.size() == t.length()) {
                windows.add(new int[]{startPointer, endPointer});
                matchIndexMap.remove(s.indexOf(s.charAt(startPointer)));
                int minIndex = endPointer;
                for (Integer index :
                        matchIndexMap.values()) {
                    if (minIndex > index) minIndex = index;
                }
                startPointer = minIndex;
            }
            endPointer++;
        }
        return s.substring(startPointer,endPointer);
    }
}

class Solution {
    String s;
    String t;
    ArrayList<int[]> windows = new ArrayList<>();
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        this.s = s;
        this.t = t;
        windows(0);
        return "";
    }

    void windows(int start) {
        int sLastIndex = s.length() - 1;
        if (sLastIndex - start < t.length()) return;
        int[] included = new int[t.length()];
        int matches = 0;
        for (int i = start; i < sLastIndex; i++) {
            for (int j = 0; j < t.length(); j++) {
                if (matches == 1) windows(i);
                if (s.charAt(i) == t.charAt(j)) {
                    included[j] = i + 1;
                    matches++;
                    break;
                }
            }
        }
        int end = start + 1;
        for (int match :
                included) {
            if (match == 0) return;
            if (end < match) end = match;
        }
        windows.add(new int[]{start, end - 1});
    }

}