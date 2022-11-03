import java.util.HashMap;

class Solution {
    public int partitionString(String s) {
        HashMap<Integer, Boolean> charactersHashMap = new HashMap<>();
        int result = 0;
        int length = s.length();
        if (length > 0) result++;
        for (int i = 0; i < length; i++) {
            Integer currentChar = Integer.valueOf(s.charAt(i));
            if (charactersHashMap.containsKey(currentChar)) {
                result++;
                charactersHashMap.clear();
            }
            charactersHashMap.put(currentChar, true);
        }
        return result;
    }
}