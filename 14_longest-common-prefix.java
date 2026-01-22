class Solution {
  public String longestCommonPrefix(String[] strs) {
    int len = strs.length;
    if (len < 2) {
      return strs[0];
    }
    // Analyze the first two strings in the array
    String longestPrefix = prefixHelper(strs[0], strs[1]);
    if (longestPrefix.length() == 0) return "";
    if (len == 2) return longestPrefix;
    for (int i = 2; i < len; i++) {
      // At this point, we've determined there are 3 or more strings in the array
      // We've found the longest common prefix between the first 2 strings
      // We need to check the remaining strings to see if they share part or all of the prefix
      // And we need to update the longestPrefix accordingly
      String temp = prefixHelper(longestPrefix, strs[i]);

      // At this point if the prefix is length 0, we can stop the algorithm
      if (temp.length() == 0) return "";

      if (temp.length() < longestPrefix.length()) {
        longestPrefix = temp;
      }
    }
    return longestPrefix;
  }

  private String prefixHelper(String s1, String s2) {
    // System.out.printf("Analyzing string: %s and %s, ", s1, s2);
    int counter = 0;
    for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        counter++;
      } else {
        // return counter;
        break;
      }
    }
    // System.out.printf("shared prefix length: %d\n", counter);
    return s1.substring(0, counter);
  }
}
