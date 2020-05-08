
/**
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * 
 * 示例 1:
 * 
 * 输入: 12 输出: 21
 * 
 * 示例 2:
 * 
 * 输入: 21 输出: -1
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 官方采用的是非Stack&Queue相关题目 但是官网却将该题放在相似题目内,于是想采用栈解决,评论区大老
 * 
 * 
 * 1.从个位数开始往高位数遍历，如果每个高位数都大于相邻的低位数，则此数字已经是最大的了，直接返回-1。
 * 2.否则遍历直到发现首次出现高位数比相邻的低位数小的情况（称这个高位数所在的位为“分界点”），这时应该在分界点右边的所有数里面找出最小的比它大的数，把两个数交换位置，此时“分界点”右边的数仍然是从大到小，两两交换使它们顺序改为从小到大，然后转换成int返回。
 * 
 * 代码
 * 
 * 作者：ben-da-xiong
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/javajie-fa-0msji-bai-100-by-ben-da-xiong/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public int nextGreaterElement(int n) {
        String string = String.valueOf(n);
        
    }
}