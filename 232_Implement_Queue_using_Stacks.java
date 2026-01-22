class MyQueue {

    Stack<Integer> mainStack; // = new Stack<>(); // most recently added on top
    Stack<Integer> tempStack; // = new Stack<>(); // least recently added on top?
    int size = 0;
    // boolean s1ContainsMostRecent=true;

    public MyQueue() {
        mainStack = new Stack<>();
    }
    
    public void push(int x) {
        // void push(int x) Pushes element x to the back of the queue.
        tempStack = new Stack<>();
        for(int i=0;i<this.size;i++) {
            tempStack.add(mainStack.pop());
        }
        tempStack.add(x);
        this.size = this.size+1;
        for(int i=0;i<this.size;i++) {
            mainStack.add(tempStack.pop());
        }

    }
    
    public int pop() {
        // int pop(): Removes the element from the front of the queue and returns it.
        if(this.size==0) return 0;
        this.size = this.size-1;
        return mainStack.pop();
    }
    
    public int peek() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        if(this.size==0) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */