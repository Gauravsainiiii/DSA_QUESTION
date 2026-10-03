import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {
    public boolean isPossible(int[] target) {
        
        if (target.length == 1) {
            return target[0] == 1;
        }


        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;

        for (int num : target) {
            totalSum += num;
            maxHeap.add((long) num);
        }

        while (true) {
            long maxVal = maxHeap.poll();
            long restSum = totalSum - maxVal;

    
            if (maxVal == 1 || restSum == 1) {
                return true;
            }

        
            if (restSum <= 0 || maxVal <= restSum) {
                return false;
            }

    
            long prevVal = maxVal % restSum;

            if (prevVal == 0) {
                return false;
            }

            
            totalSum = restSum + prevVal;
            maxHeap.add(prevVal);
        }
    }
}