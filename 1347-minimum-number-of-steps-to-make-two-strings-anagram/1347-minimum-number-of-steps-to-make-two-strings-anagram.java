class Solution {
    public int minSteps(String s, String t) {
        int[] charCounts = new int[26];

        
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        int steps = 0;
        
        for (int count : charCounts) {
            if (count > 0) {
                steps += count;
            }
        }

        return steps;
    }
}