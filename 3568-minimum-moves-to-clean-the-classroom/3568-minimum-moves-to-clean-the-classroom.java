import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = 0, startY = 0;
        int litterCount = 0;
        int[][] litterIndex = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startX = i;
                    startY = j;
                } else if (ch == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }
        

        int targetMask = (1 << litterCount) - 1;
        
        
        if (litterCount == 0) {
            return 0;
        }
        
    
        int initialMask = 0;
        

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, energy, initialMask});
        
        
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        visited[startX][startY][energy][initialMask] = true;
        
        int moves = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];
                
                
                if (mask == targetMask) {
                    return moves;
                }
                
            
                if (currEnergy == 0) {
                    continue;
                }
                
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    
                    char nextCell = classroom[nr].charAt(nc);
                    

                    int nextEnergy = (nextCell == 'R') ? energy : currEnergy - 1;
                    
                    
                    int nextMask = mask;
                    if (nextCell == 'L') {
                        nextMask |= (1 << litterIndex[nr][nc]);
                    }
                    
                    
                    if (!visited[nr][nc][nextEnergy][nextMask]) {
                        visited[nr][nc][nextEnergy][nextMask] = true;
                        queue.offer(new int[]{nr, nc, nextEnergy, nextMask});
                    }
                }
            }
            moves++;
        }
        
        return -1; 
    }
}