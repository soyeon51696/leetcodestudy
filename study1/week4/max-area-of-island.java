//https://leetcode.com/problems/max-area-of-island/description/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //time complexity is O(n*m);
        //space complexity is O(n*m), n*m times call stacks
        int n = grid.length;
        int m = grid[0].length;

        int area = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == 1) {
                    area = Math.max(area, calArea(grid, x, y));
                }
            }
        }
        
        return area;
    }

    private int calArea(int[][] grid, int x, int y) {
        if (!isInRange(grid.length, grid[0].length, x, y) || grid[y][x] == 0) {
            return 0;
        }
        // change the cell as visited to 0
        grid[y][x] = 0;

        int area = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            area += calArea(grid, newX, newY);
        }
        return area;
    }

    private boolean isInRange(int n, int m, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
