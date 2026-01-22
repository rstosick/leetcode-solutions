class Solution {
  public int countKeyChanges(String s) {
    if (s.length() == 0) return 0;
    s = s.toLowerCase();
    char[] charArray = s.toCharArray();
    char c = charArray[0];
    int count = 0;
    for (char x : charArray) {
      if (x != c) {
        count++;
        c = x;
      }
    }
    return count;
  }
}
