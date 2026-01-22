class Solution {
  public String mergeAlternately(String word1, String word2) {
    char[] word1chars = word1.toCharArray();
    char[] word2chars = word2.toCharArray();
    char[] outputChars = new char[word1.length() + word2.length()];
    int w1index = 0;
    int w2index = 0;
    int outputIndex = 0;
    while (outputIndex < outputChars.length) {
      if (w1index < word1.length()) {
        outputChars[outputIndex] = word1chars[w1index];
        w1index++;
        outputIndex++;
      }
      if (w2index < word2.length()) {
        outputChars[outputIndex] = word2chars[w2index];
        w2index++;
        outputIndex++;
      }
    }
    return String.valueOf(outputChars);
  }
}
