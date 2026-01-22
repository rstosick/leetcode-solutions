// https://leetcode.com/problems/valid-parentheses/
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
// input string is valid.

class Solution {

  private static final Map<Character, Character> openCloseMap =
      Map.of('(', ')', '[', ']', '{', '}');

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) return false; // string must have even # of chars
    char[] input = s.toCharArray();
    // Stack<Character> stack = new Stack<Character>();
    Deque<Character> stack = new ArrayDeque<>();
    Character popped = null;
    Character corresponding = null;
    for (Character current : input) {
      if (openCloseMap.get(current) != null) {
        stack.push(current);
      } else {
        if (stack.isEmpty()) return false;
        popped = stack.pop();
        corresponding = openCloseMap.get(popped);
        if (corresponding == null) return false;
        if (current.equals(corresponding) == false) return false;
      }
    }
    if (!stack.isEmpty()) return false;
    return true;
  }
}
