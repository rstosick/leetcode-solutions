class Solution {
  public String toLowerCase(String s) {
    for (int i = 65; i < 65 + 26; i++) {
      // Call s.replace() for A through Z
      // This requires 26 operations, thus the runtime is O(1)
      // The memory utilization will also be O(1)
      // If we were to iterate over the string and replace characters as we see them
      // that would make the function O(N) for both runtime and memory
      s = s.replace((char) i, (char) (i + 32));
    }
    return s;
  }
}
