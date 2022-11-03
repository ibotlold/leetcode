import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<String> array = new ArrayList<>();
//        array.add("un");
//        array.add("iq");
//        array.add("ue");

        array.add("aa");
        array.add("bb");

//        array.add("a");
//        array.add("abc");
//        array.add("d");
//        array.add("de");
//        array.add("def");
        System.out.println(new Solution().maxLength(array));
    }
}

class Solution {
    public int maxLength(List<String> arr) {
        ArrayList<HashSet> hashSets = new ArrayList<>();
        for (String string :
                arr) {
            HashSet<Character> characterHashSet = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                if (characterHashSet.contains(string.charAt(i))) {
                    characterHashSet.clear();
                    break;
                }
                characterHashSet.add(string.charAt(i));
            }
            hashSets.add(characterHashSet);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> subsequencesLengths = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if (hashSets.get(i).size() > 0) {
                stack.push(i);
                backtrack(arr, hashSets, subsequencesLengths, stack);
                stack.pop();
            }
        }
        ArrayList<Integer> lengths = new ArrayList<>(subsequencesLengths);
        lengths.sort(null);

        return lengths.size() > 0 ? lengths.get(lengths.size() - 1) : 0;
    }

    private static void backtrack(List<String> arr,
                                  ArrayList<HashSet> hashSet,
                                  Set<Integer> subsequencesLengths,
                                  Stack<Integer> stack) {
        if (stack.size() == 0) return;
        HashSet<Character> mask = new HashSet<>(hashSet.get(stack.get(0)));
        for (int i = 1; i < stack.size(); i ++) {
            Set intersection = new HashSet(mask);
            HashSet currentHashSet = hashSet.get(stack.get(i));
            intersection.retainAll(currentHashSet);
            if (intersection.size() != 0) return;
            mask.addAll(currentHashSet);
        }
        subsequencesLengths.add(mask.size());
        int nextIndex = stack.peek() + 1;
        Integer nextStep = nextIndex < arr.size() ? stack.push(nextIndex) : null;
        while (nextStep != null) {
            backtrack(arr, hashSet, subsequencesLengths, stack);
            nextIndex = stack.pop() + 1;
            nextStep = nextIndex < arr.size() ? stack.push(nextIndex) : null;
        }
    }
}