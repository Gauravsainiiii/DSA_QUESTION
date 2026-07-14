class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size() < n){
            List<Integer> temp= new ArrayList<>();
            for(int x : list){
                    temp.add(2*x-1);
                }
            
            for(int x : list) {
                    temp.add(2*x);
                }
        
            list=temp;
        }
        int[] ans = new int[n];
        int index = 0;
        for(int x : list){
            if(x<=n){
                ans[index++] = x;
            }
        }
        return ans;
        
    }
}
