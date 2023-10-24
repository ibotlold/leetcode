import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @org.junit.jupiter.api.Test
    void largestValues() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        assertArrayEquals(new int[]{1, 3}, solution.largestValues(tree).stream().mapToInt(Integer::intValue).toArray());

        tree = new TreeNode(1);
        tree.left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        tree.right = new TreeNode(2, null, new TreeNode(9));
        assertArrayEquals(new int[]{1,3,9}, solution.largestValues(tree).stream().mapToInt(Integer::intValue).toArray());
    }
}