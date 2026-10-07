class Solution {
    public int countOrders(int n) {
        long ans = 1;
        long MOD = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            
            ans = (ans * i * (2 * i - 1)) % MOD;
        }

        return (int) ans;
    }
}