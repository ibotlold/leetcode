import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Solution().groupAnagrams(new String[]{""});
//        new Solution().groupAnagrams(new String[]{"a"});
        new Solution().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}

//20x faster than old solution
//36% less memory usage
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> stringGroups = new ArrayList<>();
        HashMap<Integer, List<String>> strGroupMap = new HashMap<>();
        for (String str :
                strs) {
            int[] charFreq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                charFreq[str.charAt(i) - 'a']++;
            }
            Integer charFreqHash = Arrays.hashCode(charFreq);
            List<String> group;
            if (strGroupMap.containsKey(charFreqHash)) {
                group = strGroupMap.get(charFreqHash);
            } else {
                group = new ArrayList<>();
                strGroupMap.put(charFreqHash,group);
                stringGroups.add(group);
            }
            group.add(str);

        }
        return stringGroups;
    }
}

class OldSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        HashMap<HashMap<Character, Integer>,List<String>> hashIndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> charFreqMap = buildFreqMap(strs[i]);
            List<String> group;
            if (hashIndexMap.containsKey(charFreqMap)) {
                group = hashIndexMap.get(charFreqMap);
            } else  {
                group = new ArrayList<>();
                hashIndexMap.put(charFreqMap,group);
                groups.add(group);
            }
            group.add(strs[i]);
        }
        return groups;
    }

    private HashMap<Character, Integer> buildFreqMap(String str) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            if (!Character.isLowerCase(currentChar)) continue;
            int freq = charFreqMap.getOrDefault(currentChar, 0);
            freq++;
            charFreqMap.put(currentChar, freq);
        }
        return charFreqMap;
    }
}