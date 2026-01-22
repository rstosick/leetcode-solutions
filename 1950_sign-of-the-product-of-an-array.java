class Solution {
  public int arraySign(int[] nums) {
    int numsLength = nums.length;
    if (numsLength == 0) return 0;
    int x;
    // This variable is unnecessary strictly speaking
    // But caching the value of the number in the array speeds up performance
    // Overall worst-case runtime is O(n), best case is O(1)
    // Overall worst-case memory usage is O(1)
    int temp = nums[0];
    if (temp == 0) return 0;
    else if (temp > 0) x = 1;
    else x = -1;

    for (int i = 1; i < numsLength; i++) {
      temp = nums[i];
      if (temp == 0) return 0;
      if (temp > 0) {
        x = x * 1;
      } else {
        x = x * -1;
      }
    }
    return x;
  }
}
