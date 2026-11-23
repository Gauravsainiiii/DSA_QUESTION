class Solution {
    public int minStartValue(int[] nums) {
        int runningSum = 0;
        int minSum = 0;

        for (int num : nums) {
            runningSum += num;
            minSum = Math.min(minSum, runningSum);
        }
        return 1 - minSum;
    }
}
