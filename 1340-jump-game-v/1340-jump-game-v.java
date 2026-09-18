class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int maxJumps = 0;

    
        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, d, i, memo));
        }

        return maxJumps;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {
        
        if (memo[i] != 0) {
            return memo[i];
        }

        int maxStep = 1; 
        int n = arr.length;

        
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            
            if (arr[j] >= arr[i]) {
                break;
            }
            maxStep = Math.max(maxStep, 1 + dfs(arr, d, j, memo));
        }

        
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            
            if (arr[j] >= arr[i]) {
                break;
            }
            maxStep = Math.max(maxStep, 1 + dfs(arr, d, j, memo));
        }

        return memo[i] = maxStep;
    }
}