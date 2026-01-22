class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map1 = new HashMap<>(26 * 2);
    Map<Character, Integer> map2 = new HashMap<>(26 * 2);
    for (char c : s.toCharArray()) {
      map1.merge(c, 1, Integer::sum);
    }
    for (char c : t.toCharArray()) {
      map2.merge(c, 1, Integer::sum);
    }
    return map1.equals(map2);
  }
}
