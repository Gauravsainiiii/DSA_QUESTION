import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
    
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[] {edge[1], edge[edge.length - 1]}); 
        }

    
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[] {0, 0, 1});

    
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int curCount = curr[2];

            if (u == n - 1) {
                return d;
            }
            if (d > dist[u][curCount]) {
                continue;
            }
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                int nextCount = 1;
                if (labels.charAt(v) == labels.charAt(u)) {
                    nextCount = curCount + 1;
                }
                if (nextCount > k) {
                    continue;
                }
                if (d + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = d + weight;
                    pq.offer(new int[] {dist[v][nextCount], v, nextCount});
                }
            }
        }
        return -1;
    }
}
