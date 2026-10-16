class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        int maxSeen = 0;
        
        for (int i = 0; i < flips.length; i++) {
            
            maxSeen = Math.max(maxSeen, flips[i]);
            
            
            if (maxSeen == i + 1) {
                count++;
            }
        }
        
        return count;
    }
}
