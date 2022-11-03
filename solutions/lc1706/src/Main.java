import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        new Solution().findBall(new int[][]{
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        });
    }
}

class Solution {
    int rows;
    int columns;
    int[][] grid;
    public int[] findBall(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        this.grid = grid;
        int[] answer = new int[columns];
        for (int i = 0; i < columns; i++) {
            answer[i] = dropBall(0, i);
        }
        return answer;
    }

    private int dropBall(int row, int column) {
        if (column < 0 || column == columns) return -1;
        if (row == rows) return column;
        int board = grid[row][column];
        if (column == 0 && board == -1) return -1;
        if (column == columns - 1 && board == 1) return -1;
        int neighborBoard = grid[row][column + board];
        if (board * neighborBoard < 0) return -1;
        return dropBall(row + 1, column + board);
    }

}