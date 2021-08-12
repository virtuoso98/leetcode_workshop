class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if obstacleGrid[0][0] == 1:
            return 0
        
        obstacleGrid[0][0] = 1
        nRow = len(obstacleGrid)
        nCol = len(obstacleGrid[0])
        
        # Unique horizontal paths
        for i in range(1, nRow):
            if obstacleGrid[i][0] == 1:
                # If obstacle encountered, then set it to 0 since no unique paths
                obstacleGrid[i][0] = 0
            else:
                # If it's not an obstacle, reachability depends on previous square
                obstacleGrid[i][0] = obstacleGrid[i - 1][0]
        
        # Unique vertical paths
        for j in range(1, nCol):
            if obstacleGrid[0][j] == 1:
                # If obstacle encountered, then set it to 0 since no possible paths
                obstacleGrid[0][j] = 0
            else:
                # If it's not an obstacle, reachability depends on previous square
                obstacleGrid[0][j] = obstacleGrid[0][j - 1]
        
        # Dynamic Programming Portion
        for i in range(1, nRow):
            for j in range(1, nCol):
                if obstacleGrid[i][j] == 1:
                    # If obstacle encountered, no possible paths
                    obstacleGrid[i][j] = 0
                else:
                    # Similar logic to unique-paths
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
        
        # Return number of unique paths
        return obstacleGrid[nRow - 1][nCol - 1]