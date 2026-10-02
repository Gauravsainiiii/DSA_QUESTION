import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
    
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

    
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int n = events.length;
        int maxEventsAttended = 0;
        int currentDay = 0;


        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        
        while (i < n || !pq.isEmpty()) {
        
            if (pq.isEmpty()) {
                currentDay = events[i][0];
            }

            
            while (i < n && events[i][0] <= currentDay) {
                pq.offer(events[i][1]);
                i++;
            }

            
            while (!pq.isEmpty() && pq.peek() < currentDay) {
                pq.poll();
            }

            
            if (!pq.isEmpty()) {
                pq.poll();
                maxEventsAttended++;
                currentDay++; 
            }
        }

        return maxEventsAttended;
    }
}