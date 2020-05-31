
/**
 * 
 * 0-1 背包 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i
 * 
 * 在保证总重量不超过 W 的前提下，选择某些物品装入背包，背包的最大总价值是多少?
 * 
 * 注意:每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件
 * 
 * 
 * 假设 values 是价值数组，weights 是重量数组
 * 
 * 编号为 k 的物品，价值是 values[k]，重量是 weights[k]，k ∈ [0, n)
 * 
 * 假设 dp(i, j) 是 最大承重为 j、有前 i 件物品可选 时的最大总价值，i ∈ [1, n]，j ∈ [1, W]
 * 
 * dp(i, 0)、dp(0, j) 初始值均为 0
 * 
 * 如果 j < weights[i – 1]，那么 dp(i, j) = dp(i – 1, j)
 * 
 * 如果 j ≥ weights[i – 1]，那么 dp(i, j) = max { dp(i – 1, j), dp(i – 1, j –
 * 
 * weights[i – 1]) + values[i – 1] }
 * 
 * 
 * 
 * 
 * 0-1 背包 恰好装满
 * 
 * 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i
 * 
 * 在保证总重量七号等于 W 的前提下，选择某些物品装入背包，背包的最大总价值是多少?
 * 
 * 注意:每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件
 * 
 * dp(i, j) 初始状态调整
 * 
 * dp(i, 0) = 0，总重量恰好为 0，最大总价值必然也为 0
 * 
 * dp(0, j) = –∞(负无穷)，j ≥ 1，负数在这里代表无法恰好装满
 */

public class Knapsack {
    public static void main(String[] args) {
        int[] values = { 6, 3, 5, 4, 6 };
        int[] weights = { 2, 2, 6, 5, 4 };
        int capacity = 10;
        // dp(3,7) 代表最大承重为7 ,有前3件物品可选时的最大价值

        // i = 5 ,j = 10
        // 会有两种情况,1.如果不选择第i件物品,dp(i,j) = dp(i-1,j)
        // 如果不选择第i个物品,dp(i,j) = value(i) + dp(i-1,j-weight[i])
        System.out.println(maxValue_dp2(values, weights, capacity));
    }

    static int maxValue_dp0(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0)
            return 0;
        if (weights == null || weights.length == 0)
            return 0;
        if (values.length != weights.length || capacity <= 0)
            return 0;

        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[values.length][capacity];
    }

    // 优化为一维数组 for循环的遍历不能替换
    // dp(i, j) 都是由 dp(i – 1, k) 推导出来的，
    // 也就是说，第 i 行的数据是由它的上一行第 i – 1 行推导出来的
    // 因此，可以使用一维数组来优化
    // 另外，由于 k ≤ j ，所以 j 的遍历应该由大到小，否则导致数据错乱
    static int maxValue_dp1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0)
            return 0;
        if (weights == null || weights.length == 0)
            return 0;
        if (values.length != weights.length || capacity <= 0)
            return 0;

        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j < weights[i - 1])
                    continue;
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity];
    }

    // 因为j的for循环为递减循环,并且循环内部有continue的判断,因此可以优化掉一些循环
    static int maxValue_dp2(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0)
            return 0;
        if (weights == null || weights.length == 0)
            return 0;
        if (values.length != weights.length || capacity <= 0)
            return 0;

        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity];
    }

    /**
     * 
     * 如果返会-1 则代表无法恰好装满 
    */
    static int maxValueExactly_dp0(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0)
            return -1;
        if (weights == null || weights.length == 0)
            return -1;
        if (values.length != weights.length || capacity <= 0)
            return -1;
        int[] dp = new int[capacity + 1];

        // 全局都重置为最小值,方便接下来的max取值,保证values[i - 1] + dp[j - weights[i - 1]]也为负无穷
        for (int j = 1; j <= capacity; j++) {
            dp[j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }    
        return dp[capacity] < 0 ? -1 : dp[capacity];

    }

}