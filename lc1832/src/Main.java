import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        new Solution().checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        HashSet lettersSet = new HashSet(26);
        for (int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);
            lettersSet.add(letter);
        }
        return lettersSet.size() == 26;
    }
}