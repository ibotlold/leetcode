import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxInRow = new ArrayList<>();
        if (root == null) return maxInRow;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int max = root.val;
        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            maxInRow.add(max);
            max = queue.peek() != null ? queue.peek().val : max;
        }
        return maxInRow;
    }
}


