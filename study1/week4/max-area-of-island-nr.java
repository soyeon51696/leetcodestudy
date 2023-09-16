//https://leetcode.com/problems/max-area-of-island/
//non-recursive version

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //time complexity is O(n*m)
        //space complexity is O(n*m), because the queue can store at most O(n * m) elements
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == 1) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{y, x});
                    grid[y][x] = 0;

                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        area++;
                        for (int[] dir : directions) {
                            int newY = point[0] + dir[0];
                            int newX = point[1] + dir[1];

                            if (newY >= 0 && newY < n && newX >= 0 && newX < m && grid[newY][newX] == 1) {
                                queue.offer(new int[]{newY, newX});
                                // change the cell as visited to 0
                                grid[newY][newX] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        } 
        return maxArea;
    }
}
