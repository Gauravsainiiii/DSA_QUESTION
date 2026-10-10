class Solution {
    public int[] closestDivisors(int num) {
        
        int[] result1 = findDivisors(num + 1);
        int[] result2 = findDivisors(num + 2);
        
        
        int diff1 = Math.abs(result1[0] - result1[1]);
        int diff2 = Math.abs(result2[0] - result2[1]);
        
        return diff1 < diff2 ? result1 : result2;
    }
    
    private int[] findDivisors(int target) {
        
        for (int i = (int) Math.sqrt(target); i >= 1; i--) {
            if (target % i == 0) {
                return new int[] { i, target / i };
            }
        }
        return new int[] { 1, target }; 
    }
}