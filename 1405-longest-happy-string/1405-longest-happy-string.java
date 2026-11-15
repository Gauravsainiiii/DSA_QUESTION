import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-heap storing {character_ascii, remaining_count} sorted by count descending
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        if (a > 0) pq.offer(new int[]{'a', a});
        if (b > 0) pq.offer(new int[]{'b', b});
        if (c > 0) pq.offer(new int[]{'c', c});
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int len = sb.length();
            
            // Check if the last two characters are the same as the most frequent character
            if (len >= 2 && sb.charAt(len - 1) == first[0] && sb.charAt(len - 2) == first[0]) {
                // If no other characters are left to break the streak, we must stop
                if (pq.isEmpty()) {
                    break;
                }
                
                // Use the second most frequent character instead
                int[] second = pq.poll();
                sb.append((char) second[0]);
                second[1]--;
                
                if (second[1] > 0) {
                    pq.offer(second);
                }
                
                // Put the most frequent character back for the next turn
                pq.offer(first);
            } else {
                // Safe to append the most frequent character
                sb.append((char) first[0]);
                first[1]--;
                
                if (first[1] > 0) {
                    pq.offer(first);
                }
            }
        }
        
        return sb.toString();
    }
}
