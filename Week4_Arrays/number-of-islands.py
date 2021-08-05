class Solution:
    def dfs(self, grid: List[List[str]], x, y, nr, nc) -> None:
        if x < 0 or x >= nc:
            return
        if y < 0 or y >= nr:
            return
        
        if grid[y][x] == "0":
            return
        
        grid[y][x] = "0"
        
        self.dfs(grid, x + 1, y, nr, nc)
        self.dfs(grid, x - 1, y, nr, nc)
        self.dfs(grid, x, y + 1, nr, nc)
        self.dfs(grid, x, y - 1, nr, nc)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        nr = len(grid)
        if nr == 0:
            return 0
        nc = len(grid[0])
        nIsland = 0
        for x in range(nc):
            for y in range(nr):
                if grid[y][x] == "1":
                    nIsland += 1
                    self.dfs(grid, x, y, nr, nc)
        
        return nIsland