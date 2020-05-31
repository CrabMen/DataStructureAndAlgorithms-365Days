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
        return coinChange_Greedy0(coins, amount);
    }

    /**
     * 动态规划及其优化:
     * 
     */

    //先将问题简化(25,20,5,1) 暴力递归（自顶向下的调用，出现了重叠子问题）
    static int coinChange_dp(int amount) {
        //递归基 因为要取最小值,保证取得值为非递归基  
        if (amount < 1) return Integer.MAX_VALUE;
		if (amount == 25 || amount == 20 || amount == 5 || amount == 1) return 1;
		int min1 = Math.min(coins1(amount - 25), coins1(amount - 20));
		int min2 = Math.min(coins1(amount - 5), coins1(amount - 1));
		return Math.min(min1, min2) + 1;
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