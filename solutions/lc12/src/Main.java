import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().intToRoman(3));
//        System.out.println(new Solution().intToRoman(9));
//        System.out.println(new Solution().intToRoman(1994));
//        System.out.println(new Solution().intToRoman(58));
    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder(8);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        HashMap<Integer, char[]> dictionary = romanNumerals(num);
        for (int i = 0; i < values.length && num > 0; i++) {
            if (values[i] > num) continue;
            stringBuilder.append(dictionary.get(values[i]));
            num = num - values[i];
            if (num >= values[i]) i--;
        }
        return stringBuilder.toString();
    }
    HashMap<Integer, char[]> romanNumerals(int num) {
        HashMap<Integer, char[]> dictionary = new HashMap<>();
        dictionary.put(1, new char[]{'I'});
        dictionary.put(4, new char[]{'I','V'});
        dictionary.put(5, new char[]{'V'});
        dictionary.put(9, new char[]{'I','X'});
        dictionary.put(10, new char[]{'X'});
        dictionary.put(40, new char[]{'X','L'});
        dictionary.put(50, new char[]{'L'});
        dictionary.put(90, new char[]{'X','C'});
        dictionary.put(100, new char[]{'C'});
        dictionary.put(400, new char[]{'C','D'});
        dictionary.put(500, new char[]{'D'});
        dictionary.put(900, new char[]{'C','M'});
        dictionary.put(1000, new char[]{'M'});
        return dictionary;
    }
}