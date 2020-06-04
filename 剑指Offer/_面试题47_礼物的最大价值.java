
class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null)
            return 0;

        int rc = grid.length;
        int cc = grid[0].length;
        int[][] dp = new int[rc + 1][cc + 1];

        for (int i = 1; i <= rc; i++) {
            for (int j = 1; j <= cc; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[rc][cc];
    }
}