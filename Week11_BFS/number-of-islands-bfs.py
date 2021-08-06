class Solution:
    def makeZero(self, grid, i, j, n, m):
        q = [[i, j]]
        while q != []:
            ci, cj = q.pop(0)
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
        l, b = len(grid), len(grid[0])
        c = 0

        for i in range(l):
            for j in range(b):
                if grid[i][j] == "1":
                    c += 1
                    grid[i][j] = "0"
                    self.makeZero(grid, i, j, l, b)

        return c