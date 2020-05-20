import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 
 * 示例 1：
 * 
 * 输入：target = 9
 * 
 * 输出：[[2,3,4],[4,5]]
 * 
 * 示例 2：
 * 
 * 输入：target = 15s
 * 
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]  
 * 
 * 限制：
 * 
 * 1 <= target <= 10^5  
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int[][] findContinuousSequence(int target) {
        // 题干给出的条件为 1 <= target <= 10^5  
        List<int[]> result = new LinkedList<>();
        if (target < 3)
            return result.toArray(new int[result.size()][]);


    }

}

// class Solution {
// public int[][] findContinuousSequence(int target) {

// List<int[]> result = new ArrayList<>();
// int i = 1;

// while(target>0)
// {
// target -= i++;
// if(target>0 && target%i == 0)
// {
// int[] array = new int[i];
// for(int k = target/i, j = 0; k < target/i+i; k++,j++)
// {
// array[j] = k;
// }
// result.add(array);
// }
// }
// Collections.reverse(result);
// return result.toArray(new int[0][]);
// }
// }

// 作者：VaporMax
// 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/java-shuang-100-by-vapormax/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。