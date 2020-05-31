public class LCSubstring {
    public static void main(String[] args) {
        System.out.println(lcstring_dp1("ABCBA", "BABC"));
    }

    static int lcstring_dp0(String str1, String str2) {
        if (str1 == null || str2 == null)
            return 0;
        if (str1.length() == 0 || str2.length() == 0)
            return 0;
        char[] char1 = str1.toCharArray(); 
        char[] char2 = str2.toCharArray();

        // 代表以i和j结尾的公共子串
        int[][] dp = new int[char1.length + 1][char2.length + 1];
        int max = 0;
        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] != char2[j - 1])
                    continue;
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    // 是用一维数组 优化方案
    //时间复杂度 O(n*m);空间复杂度O(K),k= min(m,n)
    static int lcstring_dp1(String str1, String str2) {
        if (str1 == null || str2 == null)
            return 0;
        if (str1.length() == 0 || str2.length() == 0)
            return 0;
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        char[] rowChars = char1, colsChars = char2;
        if (char1.length < char2.length) {
            colsChars = char1;
            rowChars = char2;
        }

        // 代表以i和j结尾的公共子串
        int[] dp = new int[colsChars.length + 1];
        int max = 0;
        for (int row = 1; row <= rowChars.length; row++) {
            int cur = 0;
            for (int col = 1; col <= colsChars.length; col++) {
                int leftTop = cur;
                cur = dp[col];
                if (char1[row - 1] != char2[col - 1]) {
                    dp[col] = 0; //数组默认虽然为零,但是因为是重复使用的原因,需要对之前可能的值进行覆盖,进行重置
                } else {
                    dp[col] = leftTop + 1;
                }

                max = Math.max(dp[col], max);
            }
        }
        return max;
    }

}