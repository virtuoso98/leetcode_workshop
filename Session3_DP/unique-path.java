class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        /* Only 1 unique path if walking straight to the right */
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        
        /* Only 1 unique path if walking straight downwards */
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        
        /**
         * CRITICAL: Here, the DP Formula is basically the sum
         * of number of ways of reaching square above and square
         * to the left of the current square.
         */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }   
        }
        
        return dp[n - 1][m - 1];
    }
}