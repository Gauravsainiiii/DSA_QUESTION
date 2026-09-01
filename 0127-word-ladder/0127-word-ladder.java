import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
    
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return length;
                }

                char[] chars = curr.toCharArray();
                
                
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (dict.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return length + 1;
                            }
                            queue.offer(nextWord);
                            dict.remove(nextWord); 
                        }
                    }

                    chars[j] = originalChar; 
                }
            }

            length++;
        }

        return 0;
    }
}