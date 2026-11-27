class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                letters.append(c);
            }
        }

        int m = letters.length();
        int n = digits.length();

        // If the count difference is more than 1, alternating is impossible
        if (Math.abs(m - n) > 1) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int minLen = Math.min(m, n);

        // Interleave characters, starting with the group that has more elements
        for (int i = 0; i < minLen; i++) {
            if (m > n) {
                result.append(letters.charAt(i));
                result.append(digits.charAt(i));
            } else {
                result.append(digits.charAt(i));
                result.append(letters.charAt(i));
            }
        }
        if (m > n) {
            result.append(letters.charAt(m - 1));
        } else if (n > m) {
            result.append(digits.charAt(n - 1));
        }

        return result.toString();
    }
}
