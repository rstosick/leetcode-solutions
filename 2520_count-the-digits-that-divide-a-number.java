class Solution {
  public int countDigits(int num) {
    if (num < 10) return 1;
    String numString = String.valueOf(num);
    int count = 0;
    for (int i = 0; i < numString.length(); i++) {
      int temp = Integer.valueOf(Character.toString(numString.charAt(i)));
      if (num % temp == 0) count++;
    }
    return count;
  }
}
