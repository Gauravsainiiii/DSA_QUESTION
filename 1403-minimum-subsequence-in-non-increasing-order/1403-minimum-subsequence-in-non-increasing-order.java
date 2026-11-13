import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int totalSum = Arrays.stream(nums).sum();
        int subsequenceSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            subsequenceSum += nums[i];
            result.add(nums[i]);
            if (subsequenceSum > totalSum - subsequenceSum) {
                break;
            }
        }
        return result;
    }
}
