class Solution {

  private void addChar(char c, Map<Character, Integer> map) {
    map.merge(c, 1, Integer::sum);
  }

  private void removeChar(char c, Map<Character, Integer> map) {
    Integer count = map.get(c);
    if (count == null) {
      throw new IllegalArgumentException("cannot remove missing character");
    }
    if (count == 1) map.remove(c);
    else map.put(c, count - 1);
  }

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    Map<Character, Integer> count1 = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : s1.toCharArray()) {
      addChar(c, count1);
    }
    int fast = 0;
    int slow = 0;
    while (fast < s2.length()) {
      char current = s2.charAt(fast);
      addChar(current, window);

      while (fast - slow + 1 > s1.length()) {
        char left = s2.charAt(slow);
        removeChar(left, window);
        slow++;
      }

      // If window size is exactly s1.length()
      if (fast - slow + 1 == s1.length()) {
        if (count1.equals(window)) return true;
      }
      fast++;
    }
    return false;
  }
}
