//https://leetcode.com/problems/max-area-of-island/
//non-recursive version

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //time complexity is O(n*m)
        //space complexity is O(n*m), because the queue can store at most O(n * m) elements
        int m = grid.length; //row
        int n = grid[0].length; //column
        int maxArea = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        for (int x = 0; x < m; x++) { //x : 0~m
            for (int y = 0; y < n; y++) { //y : 0~n
                if (grid[x][y] == 1) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 0;

                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        area++;
                        for (int[] dir : directions) {
                            int newX = point[0] + dir[0]; 
                            int newY = point[1] + dir[1];

                            if (newY >= 0 && newY < n && newX >= 0 && newX < m && grid[newX][newY] == 1) {
                                queue.offer(new int[]{newX, newY});
                                // change the cell as visited to 0
                                grid[newX][newY] = 0;
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
