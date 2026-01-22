class Solution {

  public int maxArea(int[] height) {
    if (height.length < 2) throw new IllegalArgumentException("input is too small");
    int left = 0;
    int right = height.length - 1;
    int currentArea;
    int biggestArea = 0;

    while (left < right) {
      currentArea = (right - left) * Math.min(height[left], height[right]);
      if (currentArea > biggestArea) {
        biggestArea = currentArea;
      }
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return biggestArea;
  }
}
