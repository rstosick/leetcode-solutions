class MyHashMap {

  int numBuckets = 10; // set default value
  Map<Integer, Integer>[] mapArray;

  private int computeHash(int key) {
    return key % numBuckets;
  }

  public MyHashMap() {
    mapArray = new Map[numBuckets];
    for (int i = 0; i < numBuckets; i++) {
      Map<Integer, Integer> temp = new TreeMap<>();
      mapArray[i] = temp;
    }
  }

  public void put(int key, int value) {
    int hash = computeHash(key);
    Map<Integer, Integer> temp = mapArray[hash];
    temp.put(key, value);
  }

  public int get(int key) {
    int hash = computeHash(key);
    Map<Integer, Integer> temp = mapArray[hash];
    if (temp.containsKey(key)) return temp.get(key);
    else return -1;
  }

  public void remove(int key) {
    int hash = computeHash(key);
    Map<Integer, Integer> temp = mapArray[hash];
    temp.remove(key);
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
