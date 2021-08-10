class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # If amount is 0, 0 permutations that can produce this amount.
        if amount == 0:
            return 0
        
        # Dummy infinite value. Alternatively can use 
        # Impossible number of coins like Amount + 1.
        dp = [float('inf') for _ in range(amount + 1)]
        dp[0] = 0
        # Sort coins in ascending order
        coins.sort()
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        return dp[amount] if dp[amount] != float('inf') else -1