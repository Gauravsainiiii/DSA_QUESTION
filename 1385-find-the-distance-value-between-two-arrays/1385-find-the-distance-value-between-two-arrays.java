import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distanceValueCount = 0;

    
        for (int val : arr1) {
            if (isDistanceValid(arr2, val, d)) {
                distanceValueCount++;
            }
        }

        return distanceValueCount;
    }

    private boolean isDistanceValid(int[] arr, int target, int d) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

    
            if (Math.abs(arr[mid] - target) <= d) {
                return false; 
            }

            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true;
    }
}
