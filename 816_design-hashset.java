class MyHashSet {

  int numBuckets = 100; // set default value
  int defaultListSize = 100;
  // We can use a "jagged array"
  // https://www.geeksforgeeks.org/java/jagged-array-in-java/
  int[][] listOfLists;
  // static final int invalidConstant = Integer.MIN_VALUE;
  static final int invalidConstant = -1;

  public MyHashSet() {
    listOfLists = new int[numBuckets][];
    for (int i = 0; i < numBuckets; i++) {
      int[] temp = new int[defaultListSize];
      listOfLists[i] = temp;
      // We are guaranteed the following constraint: 0 <= key <= 10^6
      for (int j = 0; j < defaultListSize; j++) {
        temp[j] = invalidConstant;
      }
    }
  }

  private int computeHash(int key) {
    return key % numBuckets;
  }

  public void add(int key) {
    int hash = computeHash(key);
    // if(contains(key)==true) return;
    int[] originalArray = listOfLists[hash];
    // check if there is space in the array
    for (int i = 0; i < originalArray.length; i++) {
      if (originalArray[i] == key) return;
      else if (originalArray[i] == invalidConstant) {
        originalArray[i] = key;
        return;
      }
    }

    // if we are here, there was not enough space. Double the array size
    int originalSize = originalArray.length;
    int[] newArray = Arrays.copyOf(originalArray, 2 * originalSize);
    newArray[originalSize] = key;
    for (int i = originalSize + 1; i < newArray.length; i++) {
      newArray[i] = invalidConstant;
    }
    listOfLists[hash] = newArray;
  }

  public void remove(int key) {
    int hash = computeHash(key);
    // if(contains(key)==false) return;
    int[] temp = listOfLists[hash];
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == key) {
        temp[i] = invalidConstant;
        return;
      }
    }
  }

  public boolean contains(int key) {
    int hash = computeHash(key);
    for (int x : listOfLists[hash]) {
      if (x == key) return true;
    }
    return false;
  }
}

// class MyHashSet {

//     int numBuckets = 10; // set default value
//     Set<Integer>[] setArray;

//     public MyHashSet() {
//         setArray = new Set[numBuckets];
//         for(int i=0; i<numBuckets; i++) {
//             setArray[i] = new TreeSet<Integer>();
//         }
//     }

//     private int computeHash(int key) {
//         return key%numBuckets;
//     }

//     public void add(int key) {
//         int hash = computeHash(key);
//         if(contains(key)) return;
//         else setArray[hash].add(key);
//     }

//     public void remove(int key) {
//         int hash = computeHash(key);
//         if(!contains(key)) return;
//         else setArray[hash].remove(key);
//     }

//     public boolean contains(int key) {
//         return setArray[computeHash(key)].contains(key);
//     }
// }

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
 * obj.add(key); obj.remove(key); boolean param_3 = obj.contains(key);
 */
