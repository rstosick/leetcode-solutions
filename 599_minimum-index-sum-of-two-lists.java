class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> m1 = new HashMap<>();
    Set<String> s1 = new HashSet<>();
    for (int i = 0; i < list1.length; i++) {
      if (!m1.containsKey(list1[i])) {
        // we only want to add it if it's not already there
        // if we add it and it's already there, we will overwrite the (key, value)
        // pair with the same key but a higher value
        m1.put(list1[i], i);
      }
      s1.add(list1[i]);
    }

    Map<String, Integer> m2 = new HashMap<>();
    Set<String> s2 = new HashSet<>();
    // alternatively we can work backwards so if we do overwrite it,
    // we are overwriting it with a lower value
    for (int i = list2.length - 1; i >= 0; i--) {
      m2.put(list2[i], i);
      s2.add(list2[i]);
    }

    // System.out.printf("m1=%s\n", m1.toString());
    // System.out.printf("m2=%s\n", m2.toString());
    // System.out.printf("s1=%s\n", s1.toString());
    // System.out.printf("s2=%s\n", s2.toString());

    // Get all the words in both sets
    s1.retainAll(s2);
    // System.out.printf("s1=%s\n", s1.toString());

    Map<String, Integer> wordsWithIndices = new HashMap<>();
    int lowestSum = Integer.MAX_VALUE;
    // System.out.printf("lowestSum=%d\n", lowestSum);
    // Compute all of the indices for those words
    for (String word : s1) {
      int list1index = m1.get(word);
      int list2index = m2.get(word);
      int indexSum = list1index + list2index;
      wordsWithIndices.put(word, indexSum);
      if (indexSum < lowestSum) lowestSum = indexSum;
    }
    // System.out.printf("lowestSum=%d\n", lowestSum);

    List<String> intermediate = new ArrayList<>();
    for (String word : wordsWithIndices.keySet()) {
      if (wordsWithIndices.get(word) <= lowestSum) {
        intermediate.add(word);
      }
    }
    // System.out.printf("intermediate=%s\n", intermediate.toString());
    String[] output = new String[intermediate.size()];
    int i = 0;
    for (String word : intermediate) {
      output[i] = word;
      i++;
    }
    return output;
  }
}
