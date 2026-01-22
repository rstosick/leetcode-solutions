class Solution {

  private int removeSmallestValue(int[] input) {
    // The problem constraints say that the values in the input array
    // must be between 1 to 100 (inclusive). This algorithm may fail with zero values
    // or with negative numbers
    // System.out.printf("DEBUG: removeSmallestValue input array %s\n", Arrays.toString(input));
    int min = 0;
    int minPosition = 0;
    while (minPosition < input.length) {
      min = input[minPosition];
      if (min != 0) {
        break;
      } else {
        minPosition++;
      }
    }
    if (min == 0) return 0;
    // System.out.printf("First non-zero value is %d found at i=%d\n", min, minPosition);

    for (int i = minPosition; i < input.length; i++) {
      if ((input[i] < min) && input[i] != 0) {
        min = input[i];
        minPosition = i;
      }
    }
    if (min == 0) return 0;
    input[minPosition] = 0;
    // System.out.printf("smallest value is %d, at i=%d\n", min, minPosition);
    return min;
  }

  public int[] numberGame(int[] nums) {
    int[] output = new int[nums.length];
    // int outputPosition = 0;
    for (int i = 0; i < nums.length; i = i + 2) {
      // Alice's turn to remove a number
      int aliceMin = removeSmallestValue(nums);

      // Bob's turn to remove a number
      int bobMin = removeSmallestValue(nums);
      if (bobMin == 0) break;

      // Bob's turn to append to output
      if (aliceMin == 0) break;
      output[i] = bobMin;

      // Alice's turn to append to output
      if (aliceMin == 0) break;
      output[i + 1] = aliceMin;
    }
    return output;
  }
}
