class Solution:
    def dfs(self, grid: List[List[str]], x, y, nr, nc) -> None:
        # Check for out of bounds to prevent errors
        if x < 0 or x >= nc:
            return
        if y < 0 or y >= nr:
            return
        
        # If grid is water, no need to traverse anymore 
        if grid[y][x] == "0":
            return
        
        grid[y][x] = "0"
        
        # Recurse to top, bottom, left and right square relative to current
        self.dfs(grid, x + 1, y, nr, nc)
        self.dfs(grid, x - 1, y, nr, nc)
        self.dfs(grid, x, y + 1, nr, nc)
        self.dfs(grid, x, y - 1, nr, nc)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        # number of rows
        nr = len(grid)
        # if grid empty, then no islands to be found
        if nr == 0:
            return 0
        # Number of columns
        nc = len(grid[0])
        # Number of islands
        nIsland = 0
        # Double for-loop to traverse every square in grid
        for x in range(nc):
            for y in range(nr):
                # if land square is found
                if grid[y][x] == "1":
                    # increase island count
                    nIsland += 1
                    # marks whole island as found to prevent double-count
                    self.dfs(grid, x, y, nr, nc)
        
        return nIsland