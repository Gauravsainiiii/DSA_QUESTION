class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";
        
        int left = 0;
        int countOnes = 0;
        
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            
            
            while (countOnes == k) {
                
                while (s.charAt(left) == '0') {
                    left++;
                }
                
                String candidate = s.substring(left, right + 1);
                
            
                if (result.isEmpty() || candidate.length() < result.length() || 
                   (candidate.length() == result.length() && candidate.compareTo(result) < 0)) {
                    result = candidate;
                }
                
                
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
        }
        
        return result;
    }
}