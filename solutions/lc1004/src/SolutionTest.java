import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @org.junit.jupiter.api.Test
    void longestOnes() {
        assertEquals(6,solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10,solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        assertEquals(0,solution.longestOnes(new int[]{0, 0, 0, 0}, 0));
        assertEquals(4, solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0));
    }
}