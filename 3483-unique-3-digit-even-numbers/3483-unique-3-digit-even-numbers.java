import java.util.Arrays;

class Solution {
    public int totalNumbers(int[] digits) {

        int[] available = new int[10];
        for (int d : digits) {
            available[d]++;
        }

        int count = 0;

        
        for (int num = 100; num <= 998; num += 2) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int ones = num % 10;

            int[] required = new int[10];
            required[hundreds]++;
            required[tens]++;
            required[ones]++;

    
            boolean isValid = true;
            for (int d = 0; d < 10; d++) {
                if (required[d] > available[d]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }
}