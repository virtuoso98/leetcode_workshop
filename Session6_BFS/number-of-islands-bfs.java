class Solution {
    private void makeZero(
        char[][] grid, int i, int j, int n, int m
    ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
    }
    
    public int numIslands(char[][] grid) {
        int l = grid.length; int b = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == "1") {
                    count++;
                    grid[i][j] = "0";
                    makeZero(grid, i, j, l, b);
                }
            }    
        }
        
        return count;
    }
}