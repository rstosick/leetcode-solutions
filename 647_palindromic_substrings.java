class Solution {

  private boolean isPalindromeString(String input) {
    if (input == null) throw new IllegalArgumentException("null input");
    int start = 0;
    int end = input.length() - 1;
    while (start < end) {
      if (input.charAt(start) != input.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  // Brute-force approach
  public int countSubstrings(String s) {
    List<String> validPalindromes = new ArrayList<String>();
    for (int slow = 0; slow < s.length(); slow++) {
      for (int fast = slow; fast < s.length(); fast++) {
        String current = s.substring(slow, fast + 1);
        if (isPalindromeString(current)) validPalindromes.add(current);
      }
    }
    return validPalindromes.size();
  }
}
