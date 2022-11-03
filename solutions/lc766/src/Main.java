public class Main {
    public static void main(String[] args) {
        new Solution().isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        });
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) return false;
            }
        }
        return true;
    }
}