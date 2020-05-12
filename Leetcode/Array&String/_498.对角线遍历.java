import java.util.ArrayList;

/**
 * 
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * 输出: [1,2,4,7,5,3,6,8,9]
 * 
 * 解释:
 * 
 *  
 * 
 * 说明:
 * 
 * 给定矩阵中的元素总数不会超过 100000 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int rc = matrix.length; // 行数
        int cc = matrix[0].length; // 列数
        int[] result = new int[rc * cc];
        int k = 0; // 对角线数组的个数
        ArrayList<Integer> tempList = new ArrayList<>();
        // d < 对角线个数
        for (int d = 0; d < rc + cc - 1; d++) {
            tempList.clear();
            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < cc ? 0 : d - cc + 1;
            int c = d < cc ? d : cc - 1;

            while (r < rc && c > -1) {
                tempList.add(matrix[r][c]);
                ++r;
                --c;
            }
            // 每偶数次翻转数组
            if (d % 2 == 0) {
                Collections.reverse(tempList);
            }
            for (int i = 0; i < tempList.size(); i++) {
                result[k++] = tempList.get(i);
            }

        }

        return result;

    }
}