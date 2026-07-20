class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int total=m*n;
        k=k%total;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<m;i++) {
            result.add(new ArrayList<> (Collections.nCopies(n,0)));
        }
        for(int i=0;i<total;i++) {
            int oldRow=i/n;
            int oldCol=i%n;
            int newIdx=(i+k)%total;
            int newRow=newIdx/n;
            int newCol=newIdx%n;
            result.get(newRow).set(newCol,grid[oldRow] [oldCol]); 
        }
        return result;
        
    }
}