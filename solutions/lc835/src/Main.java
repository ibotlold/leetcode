public class Main {
    public static void main(String[] args) {
        int[][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = {{0,0,0},{0,1,1},{1,0,1}};
        new Solution().largestOverlap(img1,img2);
    }
}

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        final int n = img1.length;
        int maxIntersection = 0;
        int[][] transformedImg1 = new int[n][n];
        for (int right = -n + 1; right < n; right++) {
            for (int down = -n + 1; down < n; down++) {
                int intersection = 0;
                int intersectionUp = down < 0 ? 0 : down;
                int intersectionDown = down < 0 ? n + down : n;
                int intersectionLeft = right < 0 ? 0 : right;
                int intersectionRight = right < 0 ? n + right : n;
                for (int i = intersectionUp; i < intersectionDown; i++) {
                    for (int j = intersectionLeft; j < intersectionRight; j++) {
                        int row = (i - down);
                        int column = (j - right);
                        if (row < 0 || row > n) continue;
                        if (column < 0 || column > n) continue;
                        if (img1[row][column] * img2[i][j] == 1) intersection++;
                     }
                }
                if (intersection > maxIntersection) maxIntersection = intersection;
            }
        }
        return maxIntersection;
    }


}