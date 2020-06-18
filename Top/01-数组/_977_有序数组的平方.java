import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：[-4,-1,0,3,10] 输出：[0,1,9,16,100] 示例 2：
 * 
 * 输入：[-7,-3,2,3,11] 输出：[4,9,9,49,121]  
 * 
 * 提示：
 * 
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 A 已按非递减顺序排序。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

class Solution {
    public int[] sortedSquares(int[] A) {
        return sortedSquares_DoublePointer(A);
    }

    static int[] sortedSquares_Sort(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] *= A[i];
        Arrays.sort(A);
        return A;
    }

    static int[] sortedSquares_DoublePointer(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0)
                count++;
            A[i] *= A[i];
        }

        int[] tempNums = new int[count];
        for (int i = 0; i < A.length; i++)
            if (i < count) {
                tempNums[i] = A[A.length - count + i];
            }
        while (idx2 >= 0) {
            if (idx1 < A.length - count && A[idx1] > tempNums[idx2])
                result[cur--] = A[idx1--];
            else
                result[cur--] = tempNums[idx2--];
        }
        return result;
    }
}