class Solution {
   static public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        char[] suffixReq = s.toCharArray();
        return result(finish, suffixReq, limit) - result(start - 1, suffixReq, limit);
    }

    static long result(long num, char[] sarr, int limit) {
        char[] range = Long.toString(num).toCharArray();
        int n = range.length, sLen = sarr.length;
        Long[][] dp = new Long[n][2];
        boolean checkIfSTrictThenPoss = false;
        if (isSmaller(range, sarr)){
            checkIfSTrictThenPoss = isSmaller(Arrays.copyOfRange(range, (n - sarr.length) , n), sarr);
            return solve(0, 0, range, sarr, limit, n, dp, checkIfSTrictThenPoss, sLen);
        }
        return 0;
    }

    static long solve(int i, int isStrict, char[] range, char[] suffixReq, int limit, int n, Long[][] dp,
            boolean checkIfSTrictThenPoss, int sLen) {
        if (i == n) return 1;

        if (dp[i][isStrict] != null) return dp[i][isStrict];

        if (i >= n - sLen) {
            if (isStrict == 1) return checkIfSTrictThenPoss ? 1 : 0;
            return 1;
        }

        int till = limit, num = (int) (range[i] - '0');
        if (isStrict == 1 || i == 0) till = Math.min(limit, num);
        long ans = 0;

        for (int j = 0; j <= till; j++) {
            ans += solve(i + 1, (i == 0 ? (j == num ? 1 : 0) : isStrict) & (num == j ? 1 : 0), range, suffixReq, limit, n, dp, checkIfSTrictThenPoss, sLen);
        }
        return dp[i][isStrict] = ans;
    }

    static boolean isSmaller(char[] range, char[] sufffix) {
        int n1 = range.length, n2 = sufffix.length;
        if (n1 < n2) return false;
        if (n1 > n2) return true;
        for (int i = 0; i < n1; i++) {
            if (range[i] > sufffix[i]) return true;
            else if (range[i] < sufffix[i]) return false;
        }
        return true;
    }
}