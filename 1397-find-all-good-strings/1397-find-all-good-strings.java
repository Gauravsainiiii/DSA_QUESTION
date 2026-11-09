import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_057; 
    private String s1, s2, evil;
    private int n;
    private int[] lps;
    private Integer[][][][] memo;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;
        this.lps = computeLPS(evil);
        this.memo = new Integer[n][evil.length() + 1][2][2];
        return dfs(0, 0, true, true);
    }

    private int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            }
        }
        return lps;
    }

    private int getNextEvilMatch(int match, char c) {
        while (match > 0 && c != evil.charAt(match)) {
            match = lps[match - 1];
        }
        if (c == evil.charAt(match)) {
            match++;
        }
        return match;
    }

    private int dfs(int idx, int evilMatch, boolean tight1, boolean tight2) {
        if (evilMatch == evil.length()) {
            return 0; 
        }
        if (idx == n) {
            return 1; 
        }
        int t1 = tight1 ? 1 : 0;
        int t2 = tight2 ? 1 : 0;
        if (memo[idx][evilMatch][t1][t2] != null) {
            return memo[idx][evilMatch][t1][t2];
        }

        char startChar = tight1 ? s1.charAt(idx) : 'a';
        char endChar = tight2 ? s2.charAt(idx) : 'z';
        long count = 0;

        for (char c = startChar; c <= endChar; c++) {
            boolean nextTight1 = tight1 && (c == startChar);
            boolean nextTight2 = tight2 && (c == endChar);
            int nextEvilMatch = getNextEvilMatch(evilMatch, c);
            count = (count + dfs(idx + 1, nextEvilMatch, nextTight1, nextTight2)) % 1000000007;
        }

        return memo[idx][evilMatch][t1][t2] = (int) count;
    }
}
