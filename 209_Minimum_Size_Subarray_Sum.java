class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    long windowSum = 0;
    Integer answer = Integer.MAX_VALUE;
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      windowSum += nums[fast];
      while (windowSum >= target && slow < nums.length) {
        windowSum -= nums[slow];
        // answer--;
        int currentLen = fast - slow + 1;
        answer = Integer.min(answer, currentLen);
        slow++;
      }
      fast++;
    }
    if (answer == Integer.MAX_VALUE) return 0;
    else return answer;
  }
}
