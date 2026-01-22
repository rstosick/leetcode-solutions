class Solution {
  public int pivotIndex(int[] nums) {
    // Let's first handle edge cases
    if (nums.length == 0) return -1;
    // if(nums.length==1) return 0;

    // Initialize the sums
    long leftSum = 0;
    long rightSum = 0;
    int pivot = 0;
    for (int i = 1; i < nums.length; i++) {
      rightSum += nums[i];
    }
    while (pivot < nums.length) {
      // System.out.printf("DEBUG: pivot=%d, leftSum=%d, rightSum=%d\n", pivot, leftSum, rightSum);
      if (leftSum == rightSum) return pivot;
      else {
        leftSum += nums[pivot];
        if (pivot + 1 < nums.length) {
          // bounds check
          rightSum -= nums[pivot + 1];
        }
        pivot++;
      }
    }
    return -1;
  }
}
