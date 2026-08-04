import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        
        // Find minimum, maximum and store elements in a Set for O(1) lookup
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
            set.add(num);
        }
        
        // Iterate from min to max and check which numbers are missing
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}