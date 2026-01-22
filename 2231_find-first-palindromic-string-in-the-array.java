class Solution {
  private boolean isStringPalindromeHelper(String word) {
    int wordLength = word.length(); // performance optimization
    for (int i = 0; i < wordLength; i++) {
      if (word.charAt(i) != word.charAt(wordLength - i - 1)) return false;
    }
    return true;
  }

  public String firstPalindrome(String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (isStringPalindromeHelper(words[i]) == true) return words[i];
    }
    return "";
  }
}
