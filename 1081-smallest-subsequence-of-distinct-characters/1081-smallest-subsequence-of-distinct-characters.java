class Solution {
    public String smallestSubsequence(String s) { int [] count=new int[26];
    for(int i=0;i<s.length();i++){
        count[s.charAt(i) - 'a']++;
    }
    boolean[] inStack=new boolean[26];
    Stack<Character> stack=new Stack<>();
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        count[c-'a']--;
    if(inStack[c-'a']) {
        continue;
        }
        while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() -'a'] >0){ char remove=stack.pop();
        inStack[remove-'a'] = false;
    }
    stack.push(c);
    inStack[c-'a'] = true;

    }
    StringBuilder sb= new StringBuilder();
    for(char c : stack) {
        sb.append(c);
    }
    return sb.toString();
}
}