class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # Set 1 Unique path (Since what's important is
        # Top and Left border, with only 1 unique path
        # Since it is straight.
        dp = [[1 for _ in range(n)] for _ in range(m)]

        # CRITICAL: Here, the DP Formula is basically the sum
        # of number of ways of reaching square above and square
        # to the left of the current square.
        for i in range(1, n):
            for j in range(1, m):
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1]
        return dp[m - 1][n - 1]