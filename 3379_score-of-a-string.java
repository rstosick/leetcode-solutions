class Solution {
  public int scoreOfString(String s) {
    char[] inputString = s.toCharArray();
    int sum = 0;
    for (int i = 1; i < inputString.length; i++) {
      int delta = Math.abs((int) inputString[i] - (int) inputString[i - 1]);
      sum = sum + delta;
    }
    return sum;
  }
}
