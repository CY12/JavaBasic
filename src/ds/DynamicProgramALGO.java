package ds;

/**
 *
 * abcbdbc
 * dp[i][j] = false;i0 j1  ab
 * dp[i][j] = false;i1 j2  bc
 * dp[i][j] = false;i2 j3  cb
 * dp[i][j] = false;i3 j4  bd
 * dp[i][j] = false;i4 j5  db
 * dp[i][j] = false;i5 j6  bc
 * dp[i][j] = false;i0 j2  a  b  c
 * dp[i][j] = true;i1 j3   b  c  d
 * dp[i][j] = false;i2 j4  c  d  d
 * dp[i][j] = true;i3 j5   b  d  b
 * dp[i][j] = false;i4 j6  d  b  c
 * dp[i][j] = false;i0 j3  a  bc  b
 * dp[i][j] = false;i1 j4  b  cb  d
 * dp[i][j] = false;i2 j5  c  db  b
 * dp[i][j] = false;i3 j6  b  db  c
 * dp[i][j] = false;i0 j4  a  bcb  b
 * dp[i][j] = dp[i + 1][j - 1];false i1 j5  b cbd  b
 * dp[i][j] = dp[i + 1][j - 1];true i2 j6   c bdb  c
 * dp[i][j] = false;i0 j5 a bcbd b
 * dp[i][j] = false;i1 j6 b cbdb c
 * dp[i][j] = false;i0 j6 a bcbdb c
 * cbdbc
 */
public class DynamicProgramALGO {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                    System.out.println("dp[i][j] = false;i"+i+" j"+j);
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                        System.out.println("dp[i][j] = true;i"+i+" j"+j);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        System.out.println("dp[i][j] = dp[i + 1][j - 1];"+dp[i + 1][j - 1]+" i"+i+" j"+j);
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args){
        String s = "abcbdbc";
        System.out.println(longestPalindrome(s));
    }

}
