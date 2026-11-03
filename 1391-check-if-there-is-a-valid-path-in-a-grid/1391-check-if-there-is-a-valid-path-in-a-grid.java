import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        int[][][] dirs = {
            {}, 
            {{0, -1}, {0, 1}},  
            {{-1, 0}, {1, 0}},  
            {{0, -1}, {1, 0}},  
            {{0, 1}, {1, 0}},   
            {{0, -1}, {-1, 0}}, 
            {{0, 1}, {-1, 0}}   
        };
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            int currentStreetType = grid[r][c];
        
            for (int[] dir : dirs[currentStreetType]) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC]) {
                    continue;
                }
                
                int nextStreetType = grid[nextR][nextC];
                for (int[] backDir : dirs[nextStreetType]) {
                    if (nextR + backDir[0] == r && nextC + backDir[1] == c) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                        break;
                    }
                }
            }
        }
        
        return false;
    }
}
