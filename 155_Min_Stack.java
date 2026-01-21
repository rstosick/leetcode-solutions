class MinStack {
    
    // private Stack<int[]> stack = null;
    private Deque<int[]> stack = null;
    // array[0] will be the element
    // array[1] will be its corresponding minimum

    public MinStack() {
        // stack = new Stack<>();
        stack = new ArrayDeque<>(); // more efficient version
    }
    
    public void push(int val) {
        // Here's the readable version
        // int min = Math.min(val, this.getMin());
        // int[] newPair = new int[]{val, min};
        // stack.push(newPair);

        // Here's the one-liner
        stack.push(new int[]{val, Math.min(val, this.getMin())});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        // int[] top = stack.peek();
        // return top[0];
        return stack.peek()[0];
    }
    
    public int getMin() {
        if(stack.isEmpty()) return Integer.MAX_VALUE;
        // int[] top = stack.peek();
        // return top[1];
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */