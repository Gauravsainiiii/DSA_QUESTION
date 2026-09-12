import java.util.*;

public class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, n);

        
        Map<Integer, Integer> lastSeen = new HashMap<>();

    
        for (int i = 0; i < n * 2; i++) {
            int index = i % n;
            int num = nums[index];

            if (lastSeen.containsKey(num)) {
                int prevVirtualIndex = lastSeen.get(num);
                int prevIndex = prevVirtualIndex % n;
                int distance = i - prevVirtualIndex;

            
                minDist[index] = Math.min(minDist[index], distance);
                minDist[prevIndex] = Math.min(minDist[prevIndex], distance);
            }

            lastSeen.put(num, i);
        }

        List<Integer> result = new ArrayList<>(queries.length);
        for (int query : queries) {
            
            result.add(minDist[query] == n ? -1 : minDist[query]);
        }

        return result;
    }
}