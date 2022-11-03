import java.util.*;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
//        new Solution().minMutation("AAAAACCC", "AACCCCCC", new String[]{
//                "AAAACCCC",
//                "AAACCCCC",
//                "AACCCCCC"
//        });
        new Solution().minMutation("AACCGGTT", "AACCGGTA", new String[]{
                "AACCGGTA",
        });
//        new Solution().minMutation("AACCGGTT", "AAACGGTA", new String[]{
//                "AACCGGTA",
//                "AACCGCTA",
//                "AAACGGTA"
//        });
//        new Solution().minMutation("AAAACCCC", "CCCCCCCC", new String[]{
//                "AAAACCCA",
//                "AAACCCCA",
//                "AACCCCCA",
//                "AACCCCCC",
//                "ACCCCCCC",
//                "CCCCCCCC",
//                "AAACCCCC",
//                "AACCCCCC"
//        });
//        new Solution().minMutation("AACCGGTT", "AACCGCTA", new String[]{
//                "AACCGGTA",
//                "AACCGCTA",
//                "AAACGGTA"
//        });

    }
}

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> hashSet = new HashSet<>();
        boolean bankContainsEnd = false;
        for (String mutation :
                bank) {
            hashSet.add(mutation);
            if (mutation.equals(end)) bankContainsEnd = true;
        }
        if (!bankContainsEnd) return -1;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(start, 0);
        queue.offer(root);
        hashSet.remove(start);
        
        String endGeneration = start;
        while (queue.peek() != null) {
            Node current = queue.poll();
            if (current.gene.equals(end)) return current.generation;
            ArrayList<String> currentSet = new ArrayList<>(hashSet);
            for (String mutation :
                    currentSet) {
                int diff = countDiffChars(current.gene, mutation);
                if (diff != 1) continue;
                queue.offer(new Node(mutation, current.generation + 1));
                hashSet.remove(mutation);
            }
        }
        return -1;
    }

    class Node {
        String gene;
        int generation;
        public Node(String gene, int generation) {
            this.gene = gene;
            this.generation = generation;
        }
    }

    private int countDiffChars(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        int lengthDelta = a.length() - b.length();
        if (lengthDelta < 0) lengthDelta *= -1;
        return count + lengthDelta;
    }

}

class OldSolution {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<Integer, ArrayList<String>> hashtable = new HashMap<>(bank.length * 2 - 2);
        for (int i = 0; i < bank.length; i++) {
            int diff = countDiffChars(start, bank[i]);
            ArrayList<String> arrayList = hashtable.getOrDefault(diff, new ArrayList<>());
            arrayList.add(bank[i]);
            hashtable.put(diff, arrayList);
        }
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> rootMutations = hashtable.getOrDefault(1, new ArrayList<>());
        for (String root :
                rootMutations) {
            queue.offer(root);
            int count = 1;
            while (queue.peek() != null) {
                String current = queue.poll();
                if (current == end) return countDiffChars(start, end);
                if (queue.size() == 0) {
                    count++;
                    ArrayList<String> next = hashtable.get(count);
                    if (next == null) continue;
                    for (String mutations :
                            next) {
                        queue.offer(mutations);
                    }
                }
            }
        }
        return -1;
    }

    private int countDiffChars(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        int lengthDelta = a.length() - b.length();
        if (lengthDelta < 0) lengthDelta *= -1;
        return count + lengthDelta;
    }

}