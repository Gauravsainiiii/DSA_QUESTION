import java.util.Arrays;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        
    
        int maxVal = 0;
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        
        int[] freq = new int[maxVal + 1];
        for (int num : arr) {
            freq[num]++;
        }
        
    
        Arrays.sort(freq);
        
        int removedElements = 0;
        int setSize = 0;
        int target = n / 2;
        
        
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == 0) break; 
            
            removedElements += freq[i];
            setSize++;
            
            if (removedElements >= target) {
                return setSize;
            }
        }
        
        return setSize;
    }
}