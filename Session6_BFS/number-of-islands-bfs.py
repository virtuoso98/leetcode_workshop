from collections import deque

class Solution:
    def makeZero(self, grid, i, j, n, m):
        """
        Auxillary function to mark the whole island as
        travelled. Operates in a BFS manner. Whole function
        hinges on checking for Out-of-bounds condition 
        """
        q = deque()
        q.append([i, j])
        while len(q) > 0:
            ci, cj = q.popleft()
            if (ci - 1) >= 0 and grid[ci - 1][cj] == "1":
                q.append([ci - 1, cj])
                grid[ci-1][cj]="0"
            if (ci + 1) < n and grid[ci + 1][cj] == "1":
                q.append([ci + 1, cj])
                grid[ci + 1][cj] = "0"
            if (cj - 1) >= 0 and grid[ci][cj - 1] == "1":
                q.append([ci, cj - 1])
                grid[ci][cj-1] = "0"
            if (cj + 1) < m and grid[ci][cj + 1] == "1":
                q.append([ci, cj + 1])
                grid[ci][cj+1] = "0"
    
    def numIslands(self, grid: List[List[str]]) -> int:
        # Length and breadth of grid
        l, b = len(grid), len(grid[0])
        # Number of islands
        c = 0

        for i in range(l):
            for j in range(b):
                # If island encounted, then increase count by 1
                # and count it as explored
                if grid[i][j] == "1":
                    c += 1
                    grid[i][j] = "0"
                    # Activate BFS to mark island as traversed
                    self.makeZero(grid, i, j, l, b)

        return c