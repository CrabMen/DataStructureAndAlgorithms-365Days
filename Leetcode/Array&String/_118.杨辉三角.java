import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import list.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5 输出: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        int r = 0, c = 0;
        for (int i = 0; i < numRows; i++) {
            row.clear();
            for (int j = 0; j <= i; j++) {
                if (i > 0 && j > 0 && j < i) {
                    Integer num = result.get(i - 1).get(j) + result.get(i - 1).get(j - 1);
                    row.add(num);
                } else {
                    row.add(1);
                }
            }
            result.add(Collections.copy(row));
        }
        return result;
    }
}