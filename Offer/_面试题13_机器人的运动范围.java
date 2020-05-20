import java.util.LinkedList;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格
 * [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 
 * 示例 1：
 * 
 * 输入：m = 2, n = 3, k = 1
 * 
 * 输出：3
 * 
 * 示例 2：
 * 
 * 输入：m = 3, n = 1, k = 0
 * 
 * 输出：1
 * 
 * 提示：
 * 
 * 1 <= n,m <= 100
 * 
 * 0 <= k <= 20
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    int m, n, k;
    boolean[][] visited;

    // bfs需要使用到queue
    Queue<int[]> queue;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];

        // return dfs(0, 0, 0, 0);
        return bfs();
    }

    int bfs() {
        int resulut = 0;
        queue = new LinkedList();
        queue.add(new int[] { 0, 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] element = queue.remove();
            int i = element[0], j = element[1], si = element[2], sj = element[3];
            if (i >= m || j >= n || si + sj > k || visited[i][j])
                continue;
            visited[i][j] = true;
            resulut++;
            int si_plus = (i + 1) % 10 == 0 ? si - 8 : si + 1;
            int sj_plus = (j + 1) % 10 == 0 ? sj - 8 : sj + 1;
            queue.add(new int[] { i + 1, j, si_plus, sj });
            queue.add(new int[] { i, j + 1, si, sj_plus });

        }
        return resulut;
    }

    /**
     * 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
     */
    int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j])
            return 0;

        visited[i][j] = true;
        int si_plus = (i + 1) % 10 == 0 ? si - 8 : si + 1;
        int sj_plus = (j + 1) % 10 == 0 ? sj - 8 : sj + 1;
        return 1 + dfs(i + 1, j, si_plus, sj) + dfs(i, j + 1, si, sj_plus);
    }
}
