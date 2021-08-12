class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # If amount is 0, 0 permutations that can produce this amount.
        if amount == 0:
            return 0
        
        # Any unachieveable number of coins will do to check
        # whether final amount achieveable or not.
        dp = [float('inf') for _ in range(amount + 1)]
        # Only Ground truth that we know
        dp[0] = 0
        # Sort coins in ascending order to trigger DP
        coins.sort()
        for coin in coins:
            # start from coin to prevent OOB
            for i in range(coin, amount + 1):
                # dp[i - coin] + 1 would be the impt DP Relation.
                # it's like adding 1 coin to make up for the "deficit"
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        # Return minimum n(coins) if feasible, if not -1
        return dp[amount] if dp[amount] != float('inf') else -1