import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
                if (inDegree[leftChild[i]] > 1) {
                    return false; 
                }
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
                if (inDegree[rightChild[i]] > 1) {
                    return false; 
                }
            }
        }

        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) {
                    return false; 
                }
                root = i;
            }
        }

    
        if (root == -1) {
            return false;
        }

        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visitedCount++;

            int left = leftChild[current];
            if (left != -1) {
                if (visited[left]) {
                    return false;
                }
                visited[left] = true;
                queue.offer(left);
            }

            int right = rightChild[current];
            if (right != -1) {
                if (visited[right]) {
                    return false; 
                }
                visited[right] = true;
                queue.offer(right);
            }
        }

        
        return visitedCount == n;
    }
}