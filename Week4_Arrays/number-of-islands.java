class Solution {
    private void dfs(char[][] grid, int x, int y, int nr, int nc) {
        if (x < 0 || x >= nc || y < 0 || y >= nr) {
            return;
        }

        if (grid[y][x] == '0')
            return;

        grid[y][x] = '0';

        dfs(grid, x + 1, y, nr, nc);
        dfs(grid, x - 1, y, nr, nc);
        dfs(grid, x, y + 1, nr, nc);
        dfs(grid, x, y - 1, nr, nc);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int nr = grid.length;
        int nc = grid[0].length;
        int nIsland = 0;
        for (int x = 0; x < nc; x++) {
            for (int y = 0; y < nr; y++) {
                if (grid[y][x] == '1') {
                    nIsland++;
                    dfs(grid, x, y, nr, nc);
                }
            }
        }
        return nIsland;
    }
}