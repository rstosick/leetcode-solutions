class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new ArrayList<Integer>();
    int i = 0;
    for (String w : words) {
      if (w.indexOf(x) != -1) {
        indices.add(i);
      }
      i++;
    }
    return indices;
  }
}
