import java.util.Arrays;

public class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        
    
        int[] rowValidity = new int[m];
        for (int r = 0; r < m; r++) {
            int mask = 0;
            for (int c = 0; c < n; c++) {
                if (seats[r][c] == '.') {
                    mask |= (1 << c);
                }
            }
            rowValidity[r] = mask;
        }

    
        int[][] dp = new int[m][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

    
        for (int mask = 0; mask < (1 << n); mask++) {
            if (isValidSingleRow(mask, rowValidity[0])) {
                dp[0][mask] = Integer.bitCount(mask);
            }
        }

        
        for (int r = 1; r < m; r++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if (!isValidSingleRow(mask, rowValidity[r])) continue;

                for (int prevMask = 0; prevMask < (1 << n); prevMask++) {
                    if (dp[r - 1][prevMask] == -1) continue;

                    
                    if ((mask & (prevMask >> 1)) != 0) continue;
                    if ((mask & (prevMask << 1)) != 0) continue;

                    dp[r][mask] = Math.max(dp[r][mask], dp[r - 1][prevMask] + Integer.bitCount(mask));
                }
            }
        }

        
        int maxStudents = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            maxStudents = Math.max(maxStudents, dp[m - 1][mask]);
        }

        return maxStudents;
    }



    private boolean isValidSingleRow(int mask, int validMask) {
        if ((mask & validMask) != mask) return false;
        if ((mask & (mask >> 1)) != 0) return false;   
        return true;
    }
}