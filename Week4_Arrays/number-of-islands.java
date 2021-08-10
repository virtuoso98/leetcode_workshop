class Solution {
    private void dfs(char[][] grid, int x, int y, int nr, int nc) {
        /* Check for out of bounds to prevent errors */
        if (x < 0 || x >= nc || y < 0 || y >= nr) {
            return;
        }

        /* If grid is water, no need to traverse anymore */
        if (grid[y][x] == '0')
            return;

        /* Mark grid to already be traversed */
        grid[y][x] = '0';

        /* Recurse to top, bottom, left and right square relative to current  */
        dfs(grid, x + 1, y, nr, nc);
        dfs(grid, x - 1, y, nr, nc);
        dfs(grid, x, y + 1, nr, nc);
        dfs(grid, x, y - 1, nr, nc);
    }

    public int numIslands(char[][] grid) {
        /* If grid empty, then no islands to be round */
        if (grid.length == 0)
            return 0;

        /* Number of rows */
        int nr = grid.length;
        /* Number of columns */
        int nc = grid[0].length;
        /* Number of islands */
        int nIsland = 0;
        /* double for-loop to traverse every square */
        for (int x = 0; x < nc; x++) {
            for (int y = 0; y < nr; y++) {
                /* If land is found */
                if (grid[y][x] == '1') {
                    /* Increase island count */
                    nIsland++;
                    /* Mark whole island as found to prevent double-count */
                    dfs(grid, x, y, nr, nc);
                }
            }
        }
        return nIsland;
    }
}