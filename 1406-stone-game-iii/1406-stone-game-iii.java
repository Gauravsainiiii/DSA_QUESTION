class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[4];

        for (int i = n - 1; i >= 0; i--) {
            int takeSum = 0;
            int maxDiff = Integer.MIN_VALUE;
            for (int k = 0; k < 3 && i + k < n; k++) {
                takeSum += stoneValue[i + k];
                maxDiff = Math.max(maxDiff, takeSum - dp[(i + k + 1) % 4]);
            }
            
            dp[i % 4] = maxDiff;
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
