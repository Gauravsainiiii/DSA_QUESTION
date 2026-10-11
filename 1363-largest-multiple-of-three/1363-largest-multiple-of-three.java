import java.util.Arrays;

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        int[] count = new int[10];
        
        for (int d : digits) {
            sum += d;
            count[d]++;
        }
        
        int rem = sum % 3;
        
        
        if (rem == 1) {
            if (!removeDigits(count, 1, new int[]{1, 4, 7, 2, 5, 8}, new int[]{2, 5, 8, 1, 4, 7})) {
                return "";
            }
        } 
        
        else if (rem == 2) {
            if (!removeDigits(count, 2, new int[]{2, 5, 8, 1, 4, 7}, new int[]{1, 4, 7, 2, 5, 8})) {
                return "";
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }
        
    
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
    
    
    private boolean removeDigits(int[] count, int targetRem, int[] priorityOne, int[] priorityTwo) {

        for (int d : priorityOne) {
            if (d % 3 == targetRem && count[d] > 0) {
                count[d]--;
                return true;
            }
        }
    
        int removed = 0;
        for (int d : priorityTwo) {
            if (d % 3 != 0 && d % 3 != targetRem) {
                while (count[d] > 0 && removed < 2) {
                    count[d]--;
                    removed++;
                }
                if (removed == 2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}