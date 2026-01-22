class Solution {
  public int[] orArray(int[] nums) {
    int[] output = new int[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
      output[i - 1] = nums[i] | nums[i - 1];
    }
    return output;
  }
}
