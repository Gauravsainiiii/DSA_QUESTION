class Solution {
    public int preimageSizeFZF(int k) {
        long left=0;
        long right=5L * (k+1);
        while(left<=right) {
            long mid=left+(right-left) / 2;
              long zeroes = countZeroes(mid);
            if(zeroes==k) {
                return 5;
            }
            else if(zeroes<k) {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return 0;
    }
    private long countZeroes(long n) {
        long count=0;
        while(n>0){
            count += n/5;
            n/=5;
        }
        return count;
    }
}