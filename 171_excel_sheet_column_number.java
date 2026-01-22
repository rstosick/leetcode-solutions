class Solution {
  public int titleToNumber(String s) {
    int len = s.length();
    int value = 0;
    for (int i = 0; i < len; i++) {
      int curr = (int) s.charAt(i) - 64;
      int weight = len - i - 1;
      int valueTemp = curr * (int) Math.pow(26, weight);
      value = value + valueTemp;
    }
    return value;
  }
}
