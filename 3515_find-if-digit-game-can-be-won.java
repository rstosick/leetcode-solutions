class Solution {
  public boolean canAliceWin(int[] nums) {
    int singleDigit = 0;
    int doubleDigit = 0;
    for (int i = 0; i < nums.length; i++) {
      // A single digit will be less than 10
      if (nums[i] < 10) {
        singleDigit = singleDigit + nums[i];
      } else {
        doubleDigit = doubleDigit + nums[i];
      }
    }
    if (singleDigit != doubleDigit) return true;
    return false;
  }
}
