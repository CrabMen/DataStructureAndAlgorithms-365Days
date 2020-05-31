import java.lang.System.Logger;

/**
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1 示例 2:
 * 
 * 输入: coins = [2], amount = 3 输出: -1  
 * 
 * 说明: 你可以认为每种硬币的数量是无限的。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null || amount < 1)
            return 0;
        return coinChange_dp(coins, amount);
    }

    /**
     * 动态规划及其优化:
     */

    // 先将问题简化(25,20,5,1) 暴力递归（自顶向下的调用，出现了重叠子问题）
    static int coinChange_dp0(int amount) {
        // 递归基 因为要取最小值,保证取得值为非递归基
        if (amount < 1)
            return Integer.MAX_VALUE;
        if (amount == 25 || amount == 20 || amount == 5 || amount == 1)
            return 1;
        int min1 = Math.min(coinChange_dp0(amount - 25), coinChange_dp0(amount - 20));
        int min2 = Math.min(coinChange_dp0(amount - 5), coinChange_dp0(amount - 1));
        return Math.min(min1, min2) + 1;
    }

    // 通过记忆化搜索解决重复调用问题（自顶向下的调用）
    static int coinChange_dp1(int amount) {
        if (amount < 1)
            return -1;
        int[] dp = new int[amount + 1]; // 使用数组记录计算结果
        int[] coins = { 1, 5, 20, 25 };
        for (int coin : coins) {
            if (amount < coin)
                break;
            dp[coin] = 1;
        }
        return coinChange_dp1(amount, dp);
    }

    static int coinChange_dp1(int amount, int[] dp) {
        if (amount < 1)
            return Integer.MAX_VALUE;
        if (dp[amount] == 0) {// 如果当前面值没有计算过,就重新计算并赋值
            int min1 = Math.min(coinChange_dp1(amount - 25, dp), coinChange_dp1(amount - 20, dp));
            int min2 = Math.min(coinChange_dp1(amount - 5, dp), coinChange_dp1(amount - 1, dp));
            dp[amount] = Math.min(min1, min2) + 1;
        }
        return dp[amount];
    }

    // 递推 (由顶向下)
    static int coinChange_dp2(int amount) {
        if (amount < 1)
            return -1;
        int[] dp = new int[amount + 1]; // 数组默认是0 下方的 dp[1] = dp[0] + 1 = 1

        for (int i = 1; i <= amount; i++) {
            // int min = Integer.MAX_VALUE;
            // if (i >= 1)
            // Math.min(min, dp[i - 1]);
            // 上方的代码可以简写为
            int min = dp[i - 1];
            if (i >= 5)
                Math.min(min, dp[i - 5]);
            if (i >= 20)
                Math.min(min, dp[i - 20]);
            if (i >= 25)
                Math.min(min, dp[i - 25]);
            dp[i] = min + 1;
        }
        return dp[amount];
    }

    //
    static int coinChange_dp3(int amount) {
        if (amount < 1)
            return -1;
        int[] dp = new int[amount + 1]; // 数组默认是0 下方的 dp[1] = dp[0] + 1 = 1
        int[] result = new int[dp.length];
        // result[i]是凑够i分时最后那枚硬币的面值
        for (int i = 1; i <= amount; i++) {
            int min = dp[i - 1];
            result[i] = 1;
            if (i >= 5 && min < dp[i - 5]) {
                min = dp[i - 5];
                result[i] = 5;
            }
            if (i >= 20 && min < dp[i - 20]) {
                min = dp[i - 20];
                result[i] = 20;
            }
            if (i >= 25 && min < dp[i - 25]) {
                min = dp[i - 25];
                result[i] = 25;
            }
            dp[i] = min + 1;
        }
        printcoins(result, amount);
        return dp[amount];
    }

    // 打印找零结果
    static void printcoins(int[] result, int amount) {
        while (amount > 0) {
            System.out.println(result[amount]);
            amount -= result[amount];
        }
    }

    static int coinChange_dp(int[] coins, int amount) {

        if (amount < 1)
            return -1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int conin : coins) {
                if (i < conin)
                    continue;
                int v = dp[i - conin];
                if (v >= min || v < 0)
                    continue;
                min = v;
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount];
    }

    /**
     * 贪心算法:
     * 
     * 
     * 容易走到的歧路是使用贪心算法,贪心算法 贪心算法并不一定会给出最优解 下方有贪心算法的改良
     */
    static int coinChange_Greedy0(int[] coins, int amount) {
        // 对传入的面值进行排序
        Arrays.sort(coins); // 1, 5, 10, 25
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount < coins[i]) {
                continue;
            }
            amount -= coins[i];
            count++;
            // 同一面值可能出现多次,重新赋值
            i = coins.length;
        }
        return count > 0 ? count : -1;
    }

    static int coinChange_Greedy1(int[] coins, int amount) {

        Arrays.sort(coins);
        int count = 0, idx = coins.length - 1;
        while (idx >= 0) {
            if (amount < coins[idx])
                continue;
            amount -= coins[idx];
            count++;
            idx--;
        }
        return count > 0 ? count : -1;
    }

    static int coinChange_Greedy2(int[] coins, int amount) {

        Arrays.sort(coins);
        int count = 0, idx = coins.length - 1;
        while (idx >= 0) {
            while (amount >= coins[idx]) {
                amount -= coins[idx];
                count++;
            }
            idx--;
        }
        return count > 0 ? count : -1;
    }
}