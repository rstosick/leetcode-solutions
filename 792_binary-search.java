class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int middle;
    while (left <= right) {
      middle = left + ((right - left) / 2);
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        right = middle - 1;
        middle = left + ((right - left) / 2);
      } else { // current<target
        left = middle + 1;
        middle = left + ((right - left) / 2);
      }
    }
    return -1;
  }
}
