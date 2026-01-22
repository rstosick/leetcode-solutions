class Solution {
  public int totalFruit(int[] fruits) {
    int slow = 0;
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int fast = 0; fast < fruits.length; fast++) {
      int currentFruit = fruits[fast];
      map.merge(currentFruit, 1, Integer::sum);
      while (map.size() > 2) {
        int oldFruit = fruits[slow];
        int oldFruitQuantity = map.get(oldFruit);
        if (oldFruitQuantity == 1) {
          map.remove(oldFruit);
        } else {
          map.put(oldFruit, oldFruitQuantity - 1);
        }
        slow++;
      }
      max = Integer.max(max, (fast - slow) + 1);
      // if(fast-slow+1>max) max = fast-slow+1;
    }
    return max;
  }
}
