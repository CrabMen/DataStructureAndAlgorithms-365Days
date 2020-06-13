/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 
 * 示例：
 * 
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19] 输出： [3,9] 提示：
 * 
 * 0 <= len(array) <= 1000000
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

/**
 * 寻找没有排序的部分?
 * 
 * 寻找逆序对 :
 * 
 * 最右边位置的确定: 最左边位置的确定:
 * 
 */
class Solution {
    public int[] subSort(int[] array) {

        if(array == null || array.length < 3) return new int[]{-1,-1};
    
        // 从左扫描到右侧 寻找最后一个逆序对 (正序: 递增)
        int max = array[0], r = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }

        if(r==-1) return new int[]{-1,-1};


        // 从右扫描到左侧 寻找最后一个逆序对 (正序: 递增)
        int min = array[array.length -1],l = -1;
        for (int i = array.length -2 ; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }
        return  new int[]{l,r};
    }
}