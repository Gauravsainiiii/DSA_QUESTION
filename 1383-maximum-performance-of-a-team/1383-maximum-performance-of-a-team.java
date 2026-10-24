import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;
        
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerformance = 0;
        
        for (int[] eng : engineers) {
            int currEfficiency = eng[0];
            int currSpeed = eng[1];
            minHeap.offer(currSpeed);
            speedSum += currSpeed;
            if (minHeap.size() > k) {
                speedSum -= minHeap.poll();
            }
            maxPerformance = Math.max(maxPerformance, speedSum * currEfficiency);
        }
        
        return (int) (maxPerformance % MOD);
    }
}
