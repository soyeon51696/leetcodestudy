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
                        int curX = point[0];
                        int curY = point[1];
                        area++;

                        //delete unnecessary comparisons by using different if statements for each condition 
                        if (curY > 0  && grid[curX][curY - 1] == 1) {
                            queue.add(new int[]{curX, curY - 1});
                            grid[curX][curY - 1] = 0; 
                        }
                        if (curY < n - 1 && grid[curX][curY + 1] == 1) {
                            queue.add(new int[]{curX, curY + 1});
                            grid[curX][curY + 1] = 0; 
                        }
                        if (curX > 0  && grid[curX - 1][curY] == 1) {
                            queue.add(new int[]{curX - 1, curY});
                            grid[curX - 1][curY] = 0; 
                        }
                        if (curX < m - 1 && grid[curX + 1][curY] == 1) {
                            queue.add(new int[]{curX + 1, curY});
                            grid[curX + 1][curY] = 0;
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        } 
        return maxArea;
    }
}
