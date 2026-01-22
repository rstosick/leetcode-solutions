class Solution {
  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    String sanitized = "";
    for (int i = 0; i < s.length(); i++) {
      char temp = s.charAt(i);
      if ((temp >= 'a' && temp <= 'z') || (temp >= '0' && temp <= '9')) {
        sanitized = sanitized + temp;
      }
    }
    for (int i = 0; i < sanitized.length(); i++) {
      if (sanitized.charAt(i) != sanitized.charAt(sanitized.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
