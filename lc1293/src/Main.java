import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        new Solution().shortestPath(new int[][]{
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        },1);
    }
}

class Solution {
    int[][] grid;
    int[][][] maps;
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        this.grid = grid;
        maps = new int[k + 1][][];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new int[rows][columns];
        }
        Node root = new Node(0, 0, k);
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        ArrayList<Node> solutions = new ArrayList<>();
        while (queue.peek() != null) {
            Node currentNode = queue.poll();
            if (currentNode.x == columns - 1 &&
                    currentNode.y == rows - 1) {
                return maps[currentNode.k][currentNode.y][currentNode.x];
            }
            //up
            Node nextNode = createNextNode(currentNode, 0, -1);
            if (nextNode != null) queue.offer(nextNode);
            //down
            nextNode = createNextNode(currentNode, 0, 1);
            if (nextNode != null) queue.offer(nextNode);
            //left
            nextNode = createNextNode(currentNode, -1, 0);
            if (nextNode != null) queue.offer(nextNode);
            //right
            nextNode = createNextNode(currentNode, 1, 0);
            if (nextNode != null) queue.offer(nextNode);
        }
        return -1;
    }

    private Node createNextNode(Node currentNode, int dx, int dy) {
        int x = currentNode.x + dx;
        int y = currentNode.y + dy;
        if (y < 0 || y >= grid.length) return null;
        if (x < 0 || x >= grid[0].length) return null;
        if (x == 0 && y == 0) return null;
        int k = currentNode.k;
        if (maps[k][y][x] > 0) return null;
        if (grid[y][x] == 1) {
            if (k == 0) return null;
        }
        int steps = maps[k][currentNode.y][currentNode.x];
        maps[k][y][x] = steps + 1;
        if (grid[y][x] == 1) {
            k--;
            maps[k][currentNode.y][currentNode.x] = steps;
            maps[k][y][x] = steps + 1;
        }
        return new Node(x,y,k);
    }

    class Node {
        public int x;
        public int y;
        public int k;
        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}