class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int num : arr) {
            count[num]++;
        }
    
        for (int i = 500; i > 0; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        
        return -1;
    }
}
