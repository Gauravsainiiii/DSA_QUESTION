class Solution {
    public int findMinFibonacciNumbers(int k){
        int a = 1, b = 1;
        while (b <= k) {
            int next = a + b;
            a = b;
            b = next;
        }

        int count = 0;
        while (k > 0) {
            if (a <= k) {
                k -= a;
                count++;
            }
            int prev = b - a;
            b = a;
            a = prev;
        }

        return count;
    }
}
