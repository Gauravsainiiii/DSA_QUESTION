class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> available;

    public DinnerPlates(int capacity) {
        this.capacity=capacity;
        this.stacks=new ArrayList<>();
        this.available=new TreeSet<>();
        
    }
    
    public void push(int val) {
        if(available.isEmpty()) {
            stacks.add(new Stack<>());
            available.add(stacks.size()-1);
        }
        int index=available.first();
        Stack<Integer> stack=stacks.get(index);
        stack.push(val);
        if(stack.size() == capacity) {
            available.remove(index);

        }
    }
    public int pop() {
        trimTrailingEmptyStack();
        if(stacks.isEmpty()) {
            return -1;
        }
        return popAtStack(stacks.size() -1);
    }
    public int popAtStack(int index) {
        if(index<0 || index>= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }
        Stack<Integer> stack=stacks.get(index);
        int val=stack.pop();
        available.add(index);
        return val;
    }
    private void trimTrailingEmptyStack() {
        while(!stacks.isEmpty() && stacks.get(stacks.size() -1).isEmpty()) {
            int lastIndex=stacks.size() -1;
            available.remove(lastIndex);
            stacks.remove(lastIndex);
        }
    }
    
}
    
    

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */