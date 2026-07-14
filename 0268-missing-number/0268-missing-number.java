class Solution {
    public int missingNumber(int[] nums) {
      int b,c;
      int n=nums.length; 
      b = n*(n+1)/2;
      c=0;
      for(int i=0;i<nums.length; i++){
        c += nums[i];
      }  
     return b-c;
    }
}