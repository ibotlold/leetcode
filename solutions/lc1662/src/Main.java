public class Main {
    public static void main(String[] args) {
        new Solution().arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"});
    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder word1Builder = new StringBuilder();
        StringBuilder word2Builder = new StringBuilder();
        int length = word1.length > word2.length ? word1.length : word2.length;
        for (int i = 0; i < length; i++) {
            if (i < word1.length) {
                word1Builder.append(word1[i]);
            }
            if (i < word2.length) {
                word2Builder.append(word2[i]);
            }
        }
        return word1Builder.compareTo(word2Builder) == 0 ? true : false;
    }
}