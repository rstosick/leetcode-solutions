class Solution {

  private void swap(int[] nums, int pos1, int pos2) {
    if (pos1 < 0 || pos2 < 0) throw new IllegalArgumentException("negative index");
    if (pos1 >= nums.length) throw new IllegalArgumentException("out of bounds pos1");
    if (pos2 >= nums.length) throw new IllegalArgumentException("out of bounds pos1");
    int temp = nums[pos2];
    nums[pos2] = nums[pos1];
    nums[pos1] = temp;
  }

  public int heightChecker(int[] heights) {
    int[] originalArray = Arrays.copyOf(heights, heights.length);
    boolean swapped = true;
    while (swapped == true) {
      swapped = false;
      for (int i = 0; i < heights.length - 1; i++) {
        if (heights[i + 1] < heights[i]) {
          swap(heights, i + 1, i);
          swapped = true;
          continue;
        }
      }
    }
    int count = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != originalArray[i]) count++;
    }
    return count;
  }
}
