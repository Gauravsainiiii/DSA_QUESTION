class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] solution = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                solution[k++] = nums1[i++];
            }
                else{
                    solution[k++] = nums2[j++];
                }
            }
            while(i < m) {
                solution[k++] = nums1[i++];
            }
            while(j < n) {
                solution[k++] =nums2[j++];
            }
            for(int x=0;x<m+n;x++){
                nums1[x] = solution[x];
            }
        
    }
}