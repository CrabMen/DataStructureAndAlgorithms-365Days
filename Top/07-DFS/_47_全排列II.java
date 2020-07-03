/**
 * 
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 * 
 */

/**
 * 根据规律进行合理的剪枝
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        dfs(0, nums, list);
        return list;
    }

    private void dfs(int idx, int[] nums, List<List<Integer>> list) {
        // 不能再往下搜索
        if (idx == nums.length) {
            List<Integer> element = new ArrayList<>();
            for (int value : nums)
                element.add(value);
            list.add(element);
            return;
        }
        // 枚举这一层所有可以做出的选择
        for (int i = idx; i < nums.length; i++) {
            if (isRepeat(nums, idx, i))
                continue;
            swap(nums, idx, i);
            dfs(idx + 1, nums, list);
            swap(nums, idx, i);
        }
    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] = nums[i])
                return true;
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}