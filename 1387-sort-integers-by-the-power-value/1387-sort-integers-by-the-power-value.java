import java.util.Arrays;

class Solution {
    public int getKth(int lo, int hi, int k) {
        Integer[] nums = new Integer[hi - lo + 1];
        for (int i = lo; i <= hi; ++i) {
            nums[i - lo] = i;
        }
        
        Arrays.sort(nums, (a, b) -> {
            int powerA = getPower(a);
            int powerB = getPower(b);
            return powerA == powerB ? a - b : powerA - powerB;
        });
        
        return nums[k - 1];
    }
    
    private int getPower(int x) {
        int steps = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            steps++;
        }
        return steps;
    }
}
