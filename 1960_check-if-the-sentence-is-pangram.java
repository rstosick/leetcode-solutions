class Solution {
  public boolean checkIfPangram(String sentence) {

    // Not strictly necessary but will optimize runtime for
    // short inputs. By definition if it's less than the length
    // of the alphabet, it can't contain the whole alphabet
    if (sentence.length() < 26) return false;

    // We can take advantage of the uniqueness property of a set
    Set<Character> charSet = new HashSet<>();

    // the String.charAt() operation seems to be slow
    // This step is not strictly necessary but speeds up
    // the execution time while still using O(1) memory
    char[] sentenceChars = sentence.toCharArray();

    // This is also not necessary - we could reference sentence.length()
    // or sentenceChars.size in the while loop, but caching the value
    // in an int uses negligible memory and speeds up performance
    int length = sentence.length();

    int i = 0;

    // We continue the loop while both conditions are met:
    // 1. We haven't yet found the whole alphabet
    // 2. We haven't exceeded the boundaries
    // If we find every letter in the alphabet, we don't
    // need to waste compute power checking the rest of the string
    // This will optimize for very large inputs, i.e. a novel
    while (charSet.size() < 26 && i < length) {
      charSet.add(sentenceChars[i]);
      i++;
    }

    if (charSet.size() == 26) {
      return true;
    }

    return false;
  }
}
