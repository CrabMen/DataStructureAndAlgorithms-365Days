import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/**
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        // 用来保存每种组合的数组
        List<Integer> elements = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, nums, visited, elements);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> elements) {

        if (elements.size() == nums.length) {
            result.add(new ArrayList<>(elements));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            elements.add(nums[i]);
            dfs(result, nums, visited, elements);
            visited[i] = false;
            elements.remove(elements.size() - 1);
        }
    }
}