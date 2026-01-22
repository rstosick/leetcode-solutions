class Solution {
  public int differenceOfSum(int[] nums) {
    int elementSum = 0;
    int digitSum = 0;
    char[] digitCharArray;
    for (int x : nums) {
      elementSum = elementSum + x;
      digitCharArray = String.valueOf(x).toCharArray();
      for (int i = 0; i < digitCharArray.length; i++) {
        // get the value of the digit at position i
        digitSum = digitSum + Integer.valueOf(String.valueOf(digitCharArray[i]));
      }
    }
    return Math.abs(elementSum - digitSum);
  }
}
