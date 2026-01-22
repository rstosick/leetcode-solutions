class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = magazineMap(magazine);
    for (int i = 0; i < ransomNote.length(); i++) {
      // Check if it's in the map
      Character temp = Character.valueOf(ransomNote.charAt(i));
      Integer count = map.get(temp);
      if (count == null) return false;
      count--;
      if (count == 0) {
        map.remove(temp);
      } else {
        map.replace(temp, count);
      }
    }
    return true;
  }

  private Map<Character, Integer> magazineMap(String magazine) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < magazine.length(); i++) {
      // check if the character at position i is in the Map
      // if so, increment the counter by 1
      // if not, add it to the map with counter 1
      Character temp = Character.valueOf(magazine.charAt(i));
      if (map.putIfAbsent(temp, 1) != null) {
        map.replace(temp, map.get(temp) + 1);
      }
    }
    return map;
  }
}
