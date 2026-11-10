class Solution {
    public int countLargestGroup(int n) {
        int[] groupCount = new int[40];
        int maxGroupSize = 0;
        int countOfMaxGroups = 0;

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            groupCount[sum]++;

            if (groupCount[sum] > maxGroupSize) {
                maxGroupSize = groupCount[sum];
                countOfMaxGroups = 1; 
            } else if (groupCount[sum] == maxGroupSize) {
                countOfMaxGroups++; 
            }
        }

        return countOfMaxGroups;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
