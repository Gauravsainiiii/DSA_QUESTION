class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        double sum = 0.0;
        

        for (int i = 0; i < n / 2; i++) {
            sum += getExpectation(num.charAt(i));
        }
        

        for (int i = n / 2; i < n; i++) {
            sum -= getExpectation(num.charAt(i));
        }
        
        
        return sum != 0.0;
    }
    
    private double getExpectation(char c) {
        return c == '?' ? 4.5 : c - '0';
    }
}