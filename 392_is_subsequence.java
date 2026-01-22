class Solution {
  public boolean isSubsequence(String s, String t) {

    // APPROACH: We will first assume a hypothesis that s is indeed a
    // subsequence of t. We will attempt to disprove this hypothesis,
    // and return false if we are able to disprove it. Otherwise,
    // we will return true.

    char[] tArray = t.toCharArray();
    char[] subsequence = s.toCharArray();
    int sIndex = 0;
    int tIndex = 0;
    boolean found = false;
    while (sIndex < subsequence.length) {
      char temp = subsequence[sIndex];
      // System.out.printf("sIndex=%d. Considering \"%c\" from s.\n", sIndex, temp);

      // attempt to find "temp" somewhere between
      // [tIndex...tArray.length-1]
      // If we do, increment tIndex and sIndex, and continue the loop
      // Otherwise, it's not a subsequence

      found = false;
      // System.out.printf("tIndex=%d\n", tIndex);
      for (int i = tIndex; i < tArray.length; i++) {
        // System.out.printf("i=%d\n", i);
        if (tArray[i] == temp) {
          tIndex = i + 1;
          found = true;
          sIndex++;
          break;
        }
      }
      // Before executing the while loop again, check if we found the letter
      if (found == false) return false;
    }
    return true;
  }
}
