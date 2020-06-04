import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。  
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1:
 * 
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2] 输出: 2  
 * 
 * 限制：
 * 
 * 1 <= 数组长度 <= 50000
 * 
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 */

class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement_map(nums);
    }

    static int majorityElement_map(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);

            if (map.get(nums[i]) > nums.length / 2)
                return nums[i];
        }
        return 0;
    }

    // 来自评论区大佬的摩尔投票法 因题干已经强调肯定存在数组和众数
    static int majorityElement_vote0(int[] nums) {
        // votes为票数 ,cur为当前的 "众数"
        int votes = 0, cur = 0;
        for (int num : nums) {
            if (votes == 0)
                cur = num;
            votes += num == cur ? 1 : -1;
        }
        return cur;
    }

    // 普适方法,若题干未强调肯定存在众数,需要再投票结束完成以后对该 x 进行验证
    static int majorityElement_vote1(int[] nums) {
        // votes为票数 ,cur为当前的 "众数"
        int votes = 0, cur = 0, count = 0;
        for (int num : nums) {
            if (votes == 0)
                cur = num;
            votes += num == cur ? 1 : -1;
        }
        // 验证x是否为众数
        for (int num : nums)
            if (num == cur)
                count++;
        return count > nums.length / 2 ? cur : 0;
    }
}