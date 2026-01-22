class MyCircularQueue {

    private int[] array;
    private int maxCapacity = -1;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        if(k<1) throw new IllegalArgumentException("invalid queue size");
        this.maxCapacity = k;
        array = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false;
        }
        array[this.tail] = value;
        this.tail = (this.tail+1) % maxCapacity;
        size++;
        return true;
    }

    public void add(int value) {
        if(isFull()==true) throw new RuntimeException("full queue");
        else enQueue(value);
    }
    
    public boolean deQueue() {
        if(this.isEmpty()==true) return false;
        this.head = (this.head+1) % maxCapacity;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()==true) return -1;
        return array[head];
    }

    public int remove() {
        if(isEmpty()==true) throw new RuntimeException("empty queue");
        int temp = Front();
        deQueue();
        return temp;
    }
    
    public int Rear() {
        if (isEmpty()==true) return -1;
        int idx = (tail - 1 + maxCapacity) % maxCapacity;
        return array[idx];
    }
    
    public boolean isEmpty() {
        if(size==0) return true;
        else return false;
    }
    
    public boolean isFull() {
       if(size==maxCapacity) return true;
       else return false;
    }

    public int size() {
        return this.size;
    }
}

class MovingAverage {

    // private Queue<Integer> queue;
    private MyCircularQueue queue;
    private int windowSize = -1;
    private long sum = 0;

    public MovingAverage(int size) {
        queue = new MyCircularQueue(size);
        this.windowSize = size;
    }
    
    public double next(int val) {
        if(this.queue.size()>=windowSize) {
            sum -= this.queue.remove();
        }
        this.queue.add(val);
        sum += val;
        return (double) this.sum/this.queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */