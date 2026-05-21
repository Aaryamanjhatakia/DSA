
/**
 * 
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because we are filling up a 2D DP array of size m x n, and each cell takes constant time to compute.
 * Space Complexity: O(m * n) + recursion stack space, due to the storage of the DP array which keeps track of the number of unique paths to each cell in the grid.
 */

import java.util.*;

public class Memoization {
    // Function to solve the problem using recursion
    private static int func(int i, int j, int[][] dp) {
        // Base case
        if (i == 0 && j == 0) return 1;

        // If we go out of bounds, there are no ways
        if (i < 0 || j < 0) return 0;
        
        // If already computed, return it
        if (dp[i][j] != -1)
            return dp[i][j];

        // Recursive calls for up and left moves
        int up = func(i - 1, j, dp);
        int left = func(i, j - 1, dp);

        // Store the result and return
        return dp[i][j] = up + left;
    }

    // Function to count total unique paths
    public static int uniquePaths(int m, int n) {
        // DP array initialized with -1
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return func(m - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Call the method and print result
        System.out.println("Number of ways: " + uniquePaths(m, n));
    }
}


