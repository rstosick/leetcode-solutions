class MyCircularQueue {

  private int[] array; // to do: change from Integer to int
  private int maxCapacity = -1;
  private int head = 0;
  private int tail = 0;
  private int size = 0;

  public MyCircularQueue(int k) {
    // if(k<1) throw new IllegalArgumentException("invalid queue size");
    this.maxCapacity = k;
    array = new int[k];
  }

  public boolean enQueue(int value) {
    if (this.isFull()) {
      return false;
    }
    array[this.tail] = value;
    this.tail = (this.tail + 1) % maxCapacity;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (this.isEmpty() == true) return false;
    this.head = (this.head + 1) % maxCapacity;
    size--;
    return true;
  }

  public int Front() {
    if (isEmpty() == true) return -1;
    return array[head];
  }

  public int Rear() {
    if (isEmpty() == true) return -1;
    int idx = (tail - 1 + maxCapacity) % maxCapacity;
    return array[idx];
  }

  public boolean isEmpty() {
    if (size == 0) return true;
    else return false;
  }

  public boolean isFull() {
    if (size == maxCapacity) return true;
    else return false;
  }

  public int size() {
    return this.size;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new
 * MyCircularQueue(k); boolean param_1 = obj.enQueue(value); boolean param_2 = obj.deQueue(); int
 * param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean param_6
 * = obj.isFull();
 */
