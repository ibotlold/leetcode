import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxInRow = new ArrayList<>();
        if (root == null) return maxInRow;
        Deque<TreeNode> currentQueue = new ArrayDeque<>();
        Deque<TreeNode> nextQueue = new ArrayDeque<>();
        currentQueue.add(root);
        int max = root.val;
        while (currentQueue.size() > 0) {
            TreeNode node = currentQueue.remove();
            if (node.val > max) {
                max = node.val;
            }
            if (node.left != null) {
                nextQueue.add(node.left);
            }
            if (node.right != null) {
                nextQueue.add(node.right);
            }
            if (currentQueue.size() == 0) {
                maxInRow.add(max);
                if (nextQueue.size() > 0) {
                    currentQueue = nextQueue;
                    max = currentQueue.peek().val;
                    nextQueue = new ArrayDeque<>();
                }
            }

        }
        return maxInRow;
    }
}


