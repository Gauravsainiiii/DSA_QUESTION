class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the index of 0
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }
        
        // Step 2: Check if the array is cyclically increasing
        boolean isIncreasing = true;
        for (int i = 0; i < n - 1; i++) {
            int curr = nums[(zeroIdx + i) % n];
            int next = nums[(zeroIdx + i + 1) % n];
            if (next != curr + 1) {
                isIncreasing = false;
                break;
            }
        }
        
        if (isIncreasing) {
            // Option A: Directly shift left until 0 is at index 0
            int ops1 = zeroIdx; 
            // Option B: Reverse, shift left, reverse back
            int ops2 = 2 + (n - zeroIdx); 
            return Math.min(ops1, ops2);
        }
        
        // Step 3: Check if the array is cyclically decreasing
        boolean isDecreasing = true;
        for (int i = 0; i < n - 1; i++) {
            int curr = nums[(zeroIdx + i) % n];
            int next = nums[(zeroIdx + i + 1) % n];
            // After 0, the next element in a decreasing sequence cyclically is n-1
            int expectedNext = (curr == 0) ? n - 1 : curr - 1;
            if (next != expectedNext) {
                isDecreasing = false;
                break;
            }
        }
        
        if (isDecreasing) {
            // Option A: Shift left until 0 is at the end, then reverse
            int ops1 = zeroIdx + 2; 
            // Option B: Reverse first, then shift left until 0 is at index 0
            int ops2 = n - zeroIdx; 
            return Math.min(ops1, ops2);
        }
        
        // If neither pattern matches, it's impossible to sort
        return -1;
    }
}
