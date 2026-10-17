import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                children.get(manager[i]).add(i);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {headID, 0});
        
        int maxTime = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int empId = current[0];
            int currentTime = current[1];
            maxTime = Math.max(maxTime, currentTime);
            
            for (int subordinate : children.get(empId)) {
                queue.offer(new int[] { subordinate, currentTime + informTime[empId] });
            }
        }
        
        return maxTime;
    }
}