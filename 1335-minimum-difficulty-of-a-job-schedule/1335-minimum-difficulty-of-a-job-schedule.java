import java.util.Arrays;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        

        if (n < d) {
            return -1;
        }

        int[][] memo = new int[n][d + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(jobDifficulty, d, 0, memo);
    }

    private int dfs(int[] jobDifficulty, int daysLeft, int index, int[][] memo) {
        int n = jobDifficulty.length;

    
        if (daysLeft == 1) {
            int maxDiff = 0;
            for (int i = index; i < n; i++) {
                maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            }
            return maxDiff;
        }

        if (memo[index][daysLeft] != -1) {
            return memo[index][daysLeft];
        }

        int maxDiff = 0;
        int minTotalDiff = Integer.MAX_VALUE;

        
        
        for (int i = index; i <= n - daysLeft; i++) {
            maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            minTotalDiff = Math.min(minTotalDiff, maxDiff + dfs(jobDifficulty, daysLeft - 1, i + 1, memo));
        }

        return memo[index][daysLeft] = minTotalDiff;
    }
}