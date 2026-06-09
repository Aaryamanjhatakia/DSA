
public class Tabulation {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //Base case: fill first row
        for(int target=0; target<=amount; target++){

            if(target % coins[0] == 0)
            dp[0][target] = target/coins[0];
            else
            dp[0][target] = (int)1e9;
        }

        //fill remaining rows
        for(int index = 1; index < n; index++){
            for(int target = 0; target <= amount; target++){

                int notTake = dp[index-1][target];
                int take = (int)1e9;

                if(coins[index] <= target)
                take = 1 + dp[index][target - coins[index]];

                dp[index][target] = Math.min(take, notTake);
            }
        }

        int ans = dp[n-1][amount];

        return ans >= (int)1e9 ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        Tabulation obj = new Tabulation();
        System.out.println(obj.coinChange(coins, amount));
    }
}
