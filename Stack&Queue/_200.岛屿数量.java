import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 刚看到这个题目其实首先想到的是 采用图的方式解决.但是对应的课程还没有看完;
 * 
 * 该题目出现在数据结构 -- 队列中,设计到的知识点为 BFS 广度优先搜索
 * 
 */

/**
 * 
 * 又是直奔题解的一天 
 */
class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int rc = grid.length; // 行数
        int cc = grid[0].length; // 列数
        int islands_count = 0;

        for (int r = 0; r < rc; ++r) {
            for (int c = 0; c < cc; ++c) {

                if (grid[r][c] == '1') {
                    ++islands_count;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * cc + c);
                    grid[r][c] = '0';

                    while (!queue.isEmpty()) {
                        int idx = queue.poll();
                        int row = idx / cc;
                        int col = idx % cc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer((row - 1) * cc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rc && grid[row + 1][col] == '1') {
                            queue.offer((row + 1) * cc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(row * cc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < cc && grid[row][col + 1] == '1') {
                            queue.offer(row * cc + col + 1);
                            grid[row][col + 1] = '0';
                        }

                    }

                }

            }

        }
        return islands_count;

    }
}

// 下方为评论区某位大佬的解题思路

// 思路：遍历岛这个二维数组，如果当前数为1，则进入感染函数并将岛个数+1
// 感染函数：其实就是一个递归标注的过程，它会将所有相连的1都标注成2。为什么要标注？这样就避免了遍历过程中的重复计数的情况，一个岛所有的1都变成了2后，遍历的时候就不会重复遍历了。建议没想明白的同学画个图看看。
// 附上Java代码
// class Solution {
//     public int numIslands(char[][] grid) {
//         int islandNum = 0;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == '1'){
//                     infect(grid, i, j);
//                     islandNum++;
//                 }
//             }
//         }
//         return islandNum;
//     }
//     //感染函数
//     public void infect(char[][] grid, int i, int j){
//         if(i < 0 || i >= grid.length ||
//            j < 0 || j >= grid[0].length || grid[i][j] != '1'){
//             return;
//         }
//         grid[i][j] = '2';
//         infect(grid, i + 1, j);
//         infect(grid, i - 1, j);
//         infect(grid, i, j + 1);
//         infect(grid, i, j - 1);
//     }
// }
