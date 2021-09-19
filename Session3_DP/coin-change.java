import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        /* Unachievable number of coins that can be used */
        int max = amount + 1;
        if (amount == 0) {
            return 0;
        }

        /* Fill DP Array */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        /* Only Ground truth that we know */
        dp[0] = 0;
        /* Sort coins in ascending order to trigger DP */
        Arrays.sort(coins);
        for (int coin : coins) {
            /* Start from coins to prevent OOB */
            for (int idx = coin; idx < dp.length; idx++) {
                /** 
                 * dp[i - coin] + 1 would be the impt DP Relation.
                 * it's like adding 1 coin to make up for the "deficit"
                 */
                dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}