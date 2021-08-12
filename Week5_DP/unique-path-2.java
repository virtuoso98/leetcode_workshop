class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /* If first square is a rock, then robot cannot even move */
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        /* Signifies robot can move */
        obstacleGrid[0][0] = 1;
        int nRow = obstacleGrid.length;
        int nCol = obstacleGrid[0].length;

        /* Unique horizontal paths */
        for (int i = 1; i < nRow; i++) {
            if (obstacleGrid[i][0] == 1) {
                /* If obstacle encountered, then set it to 0 since no unique paths */
                obstacleGrid[i][0] = 0;
            } else {
                /* If it's not an obstacle, reachability depends on previous square */
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }

        /* Unique vertical paths */
        for (int j = 1; j < nCol; j++) {
            if (obstacleGrid[0][j] == 1) {
                /* If obstacle encountered, then set it to 0 since no possible paths */
                obstacleGrid[0][j] = 0;
            } else {
                /* If it's not an obstacle, reachability depends on previous square */
                obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            }
        }

        /* Dynamic Programmign Portion */
        for (int i = 1; i < nRow; i++) {
            for (int j = 1; j < nCol; j++) {
                if (obstacleGrid[i][j] == 1) {
                    /* If obstacle encountered, no possible paths */
                    obstacleGrid[i][j] = 0;
                } else {
                    /* Similar logic to unique paths */
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        /* Return number of unique paths */
        return obstacleGrid[nRow - 1][nCol - 1];
    }
}