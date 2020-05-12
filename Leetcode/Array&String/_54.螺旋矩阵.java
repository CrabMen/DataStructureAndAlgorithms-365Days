import java.awt.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ]
 * 
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/**
 *
 * 绘制螺旋轨迹路径，我们发现当路径超出界限或者进入之前访问过的单元格时，会顺时针旋转方向。
 * 
 * 算法
 * 
 * 假设数组有 {R}R 行 {C}C 列，{seen[r][c]}seen[r][c] 表示第 r 行第 c 列的单元格之前已经被访问过了。当前所在位置为
 * {(r, c)}(r, c)，前进方向是 {di}di。我们希望访问所有 {R}R x {C}C 个单元格。
 * 
 * 当我们遍历整个矩阵，下一步候选移动位置是 {(cr,cc)}(cr, cc)。
 * 
 * 如果这个候选位置在矩阵范围内并且没有被访问过，那么它将会变成下一步移动的位置；否则，我们将前进方向顺时针旋转之后再计算下一步的移动位置。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix == null || matrix.length == 0)
            return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = { 0, 1, 0, -1 }; // 行上下左右方向
        int[] dc = { 1, 0, -1, 0 }; // 列上下左右方向
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (cr >= 0 && cc >= 0 && cr < R && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                //如果越界了修改方向
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}
