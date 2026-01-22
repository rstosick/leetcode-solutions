class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;
    int count = 1;
    int insertIndex = 1;
    int currentElement = nums[0];
    int fastPtr;
    for (fastPtr = 1; fastPtr < nums.length; fastPtr++) {
      if (nums[fastPtr] == currentElement) {
        count++;
      } else {
        currentElement = nums[fastPtr];
        count = 1;
      }

      // See if we need to start overwriting
      if (count <= 2) {
        nums[insertIndex] = nums[fastPtr];
        insertIndex++;
      }
    }

    return insertIndex;
  }
}
