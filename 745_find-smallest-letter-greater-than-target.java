class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    Character output = null; // we could also use a char and initialize it to 'z'+1
    int low = 0;
    int high = letters.length - 1;
    int mid;
    while (low <= high) {
      mid = low + ((high - low) / 2);
      char midChar = letters[mid];
      if (midChar == target + 1) {
        output = midChar;
        return output;
      }
      if (midChar > target) {
        if (output == null || midChar < output) {
          output = midChar;
        }
      }
      // If we overshot
      if (midChar > target + 1) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (output != null) return output;
    else return letters[0];
  }
}
