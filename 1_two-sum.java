class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new TreeMap<>();
    int delta;
    for (int i = 0; i < nums.length; i++) {
      delta = target - nums[i];
      Integer deltaIndex = map.get(delta);
      if (deltaIndex != null) {
        return new int[] {i, map.get(delta)};
      } else {
        map.put(nums[i], i);
      }
    }
    // If we've gotten to here, invalid input
    // throw new IllegalArgumentException("invalid input");
    return null;
  }
}
