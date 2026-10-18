import java.util.*;

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[n + 1];
        double[] prob = new double[n + 1];

        q.offer(1);
        seen[1] = true;
        prob[1] = 1.0;

        while (!q.isEmpty() && t > 0) {
            int size = q.size();
            t--;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                int unvisitedCount = 0;
                for (int neighbor : tree.get(curr)) {
                    if (!seen[neighbor]) {
                        unvisitedCount++;
                    }
                }
                for (int neighbor : tree.get(curr)) {
                    if (!seen[neighbor]) {
                        seen[neighbor] = true;
                        prob[neighbor] = prob[curr] / unvisitedCount;
                        q.offer(neighbor);
                    }
                }
                if (unvisitedCount > 0) {
                    prob[curr] = 0.0;
                }
            }
        }

        return prob[target];
    }
}