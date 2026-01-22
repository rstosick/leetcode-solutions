class Solution {
  public String reverseWords(String s) {
    s = s.strip();
    String[] myArray = s.split(" ");
    String output = "";
    for (String word : myArray) {
      if (word.isBlank() == false) {
        output = word + " " + output;
      }
    }
    return output.strip();
  }
}
