class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long aba = 6; 
        long abc = 6; 
        
        for (int i = 2; i <= n; i++) {
            long nextAba = (3 * aba + 2 * abc) % MOD;
            long nextAbc = (2 * aba + 2 * abc) % MOD;
            
            aba = nextAba;
            abc = nextAbc;
        }
        
        return (int) ((aba + abc) % MOD);
    }
}
