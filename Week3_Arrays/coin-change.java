import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            for (int idx = coin; idx < dp.length; idx++) {
                dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
            }
        }

        if (dp[amount] == max) {
            return -1;
        }
        return dp[amount];
    }
}