/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * 
 * 
 * 示例 1：
 * 
 * 输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234
 * 
 * 示例 2：
 * 
 * 输入：A = [2,7,4], K = 181 输出：[4,5,5] 解释：274 + 181 = 455
 * 
 * 示例 3：
 * 
 * 输入：A = [2,1,5], K = 806 输出：[1,0,2,1] 解释：215 + 806 = 1021
 * 
 * 示例 4：
 * 
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1 输出：[1,0,0,0,0,0,0,0,0,0,0] 解释：9999999999
 * + 1 = 10000000000  
 * 
 * 提示：
 * 
 * 1 <= A.length <= 10000 0 <= A[i] <= 9 0 <= K <= 10000 如果 A.length > 1，那么 A[0]
 * != 0
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/**
 *
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/shu-zu-xing-shi-de-zheng-shu-jia-fa-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 下方解法来自官方题解的评论区:
 * K为大数时，题解有溢出风险（但题中已交代K的范围，所以此题可行），所以应当将K按位转化为数组。
 * 
 */

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        //得出K的位数
        int lenB = 0;  
        while (K >= Math.pow(10, lenB)) {
            lenB++;
        }

        //将k转化为数组
        int[] B = new int[lenB];
        while (lenB > 0) {
            B[--lenB] = K % 10;
            K = K / 10;
        }

        Integer i = A.length - 1;
        Integer j = B.length - 1;
        int n = i > j ? i : j;   //防止数组越界,保证相加为的最大index
        int[] ansArray = new int[n + 1];
        int num = 0;
        while (i >= 0 && j >= 0) {
            ansArray[n--] = (A[i] + B[j] + num) % 10;
            num = (A[i--] + B[j--] + num) / 10;
        }
        while (i >= 0) {
            ansArray[n--] = (A[i] + num) % 10;
            num = (A[i--] + num) / 10;
        }
        while (j >= 0) {
            ansArray[n--] = (B[j] + num) % 10;
            num = (B[j--] + num) / 10;
        }
        List<Integer> ansList = new ArrayList<>();
        if (num != 0)
            ansList.add(num);
        for (int val : ansArray)
            ansList.add(val);
        return ansList;
    }

}