class Solution {
  public int[] sortedSquares(int[] nums) {
    int[] output = new int[nums.length];
    int head = 0;
    int tail = nums.length - 1;
    int option1;
    int option2;
    int i = nums.length - 1;
    while (head <= tail) {
      // Check the beginning of nums
      option1 = nums[head] * nums[head];

      if (tail == head) {
        // always choose head
        output[i] = option1;
        head++;
      } else {
        // Check the end of nums
        // We want to compute option 2 inside the else to avoid
        // unnecessary operations
        option2 = nums[tail] * nums[tail];
        if (option1 < option2) {
          output[i] = option2;
          tail--;
        } else {
          // case where they are equal
          // always choose the head
          output[i] = option1;
          head++;
        }
      }
      i--;
    }
    return output;
  }
}
