import java.util.Arrays;

class Solution {
    private int[][][] memo;
    private int m, n;
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        long totalPaths = 0;
    
        totalPaths = (totalPaths + dfs(0, 1, 0, grid)) % MOD;
        totalPaths = (totalPaths + dfs(1, 0, 1, grid)) % MOD;

        return (int) totalPaths;
    }

    private int dfs(int r, int c, int dir, int[][] grid) {
    
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }

        if (grid[r][c] == 1) {
            if (dir == 0) {
        
                return dfs(r + 1, c, 1, grid);
            } else {
                
                return dfs(r, c + 1, 0, grid);
            }
        }
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

    
        if (memo[r][c][dir] != -1) {
            return memo[r][c][dir];
        }

        long paths = 0;

    
        paths = (paths + dfs(r, c + 1, 0, grid)) % MOD;
        
        paths = (paths + dfs(r + 1, c, 1, grid)) % MOD;

        return memo[r][c][dir] = (int) paths;
    }
}
