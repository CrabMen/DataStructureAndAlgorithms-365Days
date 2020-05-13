import java.math.BigInteger;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *  
 * 示例 1:
 * 
 * 输入: a = "11", b = "1" 输出: "100" 
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011" 输出: "10101"  
 * 
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。 1 <= a.length, b.length <= 10^4 字符串如果不是 "0" ，就都不含前导零。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 194 / 294 个通过测试用例
 * 
 * 错误信息: Line 3: java.lang.NumberFormatException: For input string:
 * "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
 * under radix 2
 * 
 * 最后执行的输入：
 * "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
 * "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
 * 
 * 
 * 分析:
 * 
 * 在 Java 中，该方法受输入字符串 a 和 b 的长度限制。
 * 
 * 字符串长度太大时，不能将其转换为 Integer，Long 或者 BigInteger
 * 类型。 33 位 1，不能转换为 Integer。
 * 
 * 65 位 1，不能转换为 Long。
 * 
 * 500000001 位 1，不能转换为 BigInteger。
 * 
 * 因此，为了适用于长度较大的字符串计算，应该使用逐比特位的计算方法。
 * 
 * 如果输入的数字很大，该方法的效率非常低。 使用位操作提高计算速度。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 
 */

// class Solution {
//     public String addBinary(String a, String b) {
//         return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
//     }
// }
/**
 * xor计算 一脸懵逼
 * 
*/
class Solution {
    public String addBinary(String a, String b) {
      BigInteger x = new BigInteger(a, 2);
      BigInteger y = new BigInteger(b, 2);
      BigInteger zero = new BigInteger("0", 2);
      BigInteger carry, answer;
      while (y.compareTo(zero) != 0) {
        answer = x.xor(y);
        carry = x.and(y).shiftLeft(1);
        x = answer;
        y = carry;
      }
      return x.toString(2);
    }
  }
 