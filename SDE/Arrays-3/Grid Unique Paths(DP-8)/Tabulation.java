/**
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because we are filling up a 2D DP array of size m x n, and each cell takes constant time to compute.
 * Space Complexity: O(m * n), as we are using a 2D array to store the results of subproblems. However, we can optimize this to O(n) by using a 1D array and updating it in place.
 */
import java.util.*;


public class Tabulation {
    // Function to solve the problem using tabulation
    int func(int m, int n, int[][] dp) {
        // Loop through the grid using two nested loops
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue; 
                }

                int up = 0;
                int left = 0;

                // Check cell above
                if (i > 0)
                    up = dp[i - 1][j];

                // Check cell to the left
                if (j > 0)
                    left = dp[i][j - 1];

                // Total ways to reach this cell
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    // Function to count total ways
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return func(m, n, dp);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Create Solution object
        Tabulation sol = new Tabulation();

        // Call and print result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }
}
