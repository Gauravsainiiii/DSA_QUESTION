import java.util.LinkedList;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            p.add(i);
        }
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int index = p.indexOf(q);
            result[i] = index;
            p.remove(index);
            p.addFirst(q);
        }
        
        return result;
    }
}
