class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length-1);
        return nums;
        
    }
    public void divide(int[] arr,int left,int right) {
        if(left>=right) 
        return;
    int mid = (left+(right-left)/2);
    divide(arr,left,mid);
    divide(arr,mid+1,right);
    merge(arr,left ,mid,right); 
}
private void merge(int[] arr,int left,int mid,int right) {
    int[] result = new int[right-left+1];
    int i=left;int j=mid+1;int k=0;
    while(i<=mid && j<=right) {
        if(arr[i]<=arr[j]) {
            result[k++] = arr[i++];
        }
        else{
            result[k++] = arr[j++];
        }
    }
    while(i<=mid) {
        result[k++] = arr[i++];
    }
    while(j <= right) {
        result[k++] = arr[j++];
    }
    for(int x=0;x<result.length;x++)
    arr[left+x] = result[x];
}
}