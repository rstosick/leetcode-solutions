class Solution {
  public int mostWordsFound(String[] sentences) {
    int max = 0;
    for (String s : sentences) {
      // String[] wordsInSentence = s.split(" ");
      // max = Math.max(max, wordsInSentence.length);
      max = Math.max(max, s.split(" ").length);
    }
    return max;
  }
}
