class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if obstacleGrid[0][0] == 1:
            return 0
        
        obstacleGrid[0][0] = 1
        nRow = len(obstacleGrid)
        nCol = len(obstacleGrid[0])
        
        for i in range(1, nRow):
            if obstacleGrid[i][0] == 1:
                obstacleGrid[i][0] = 0
            else:
                obstacleGrid[i][0] = obstacleGrid[i - 1][0]
        
        for j in range(1, nCol):
            if obstacleGrid[0][j] == 1:
                obstacleGrid[0][j] = 0
            else:
                obstacleGrid[0][j] = obstacleGrid[0][j - 1]
        
        for i in range(1, nRow):
            for j in range(1, nCol):
                if obstacleGrid[i][j] == 1:
                    obstacleGrid[i][j] = 0
                else:
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
        
        return obstacleGrid[nRow - 1][nCol - 1]