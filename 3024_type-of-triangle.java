class Solution {
  public String triangleType(int[] nums) {
    // if(nums.length!=3) return "none";
    Arrays.sort(nums);
    if (nums[0] + nums[1] <= nums[2]) {
      return "none";
    }
    // If two numbers are the same, it must be either isoceles or equilateral
    // We need to compare nums[0]==nums[1] and also nums[1]==nums[2]
    if (nums[0] == nums[1]) {
      if (nums[0] == nums[2]) return "equilateral";
      else return "isosceles";
    }
    if (nums[1] == nums[2]) {
      // We've already exhausted the possibility of it being an equilaterial triangle
      return "isosceles";
    }
    return "scalene";
  }
}
