//https://leetcode.com/problems/flood-fill/description/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //time complexity is O(m*n=N) = O(N) (N is the total number of pixels in the image)
        //space complexity is O(m*n=N), in the worst case, the queue may store all the pixels in the image

        int originalColor  = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        
        //direction
        // int[] up = {-1, 0};
        // int[] down = {1, 0};
        // int[] r = {0, -1};
        // int[] l = {0, 1};
        // int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int n = image.length;
        int m = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            image[x][y] = color;

            //to avoid an unnecessary comparison
            //It's better in these case to unroll this loop and compare one by one
            if (y > 0  && image[x][y - 1] == originalColor) {
                queue.add(new int[]{x, y - 1});
            }
            if (y < m - 1 && image[x][y + 1] == originalColor) {
                queue.add(new int[]{x, y + 1});
            }
            if (x > 0  && image[x - 1][y] == originalColor) {
                queue.add(new int[]{x - 1, y});
            }
            if (x < n - 1 && image[x + 1][y] == originalColor) {
                queue.add(new int[]{x + 1, y});
            }         

            // for (int i = 0; i < directions.length; i++) {
            //     int newX = x + directions[i][0];
            //     int newY = y + directions[i][1];

            //     if (isInRange(n, m, newX, newY) && image[newX][newY] == originalColor) {
            //         queue.add(new int[]{newX, newY});
            //     }
            // }
        }
        return image;
    
    }

    // public boolean isInRange(int n, int m, int x, int y) {
    //     return x >= 0 && x < n && y >= 0 && y < m;
    // }
}
