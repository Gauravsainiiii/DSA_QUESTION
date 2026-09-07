class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
    
        long dp = 0;
        
        
        long[] last = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
        
            long newSubsequences = (dp + 1 - last[idx] + MOD) % MOD;
            
        
            dp = (dp + newSubsequences) % MOD;
            
            
            last[idx] = (last[idx] + newSubsequences) % MOD;
        }
        
        return (int) dp;
    }
}