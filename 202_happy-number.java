class Solution {

  // This solution is (somewhat) clean and easy to debug, because we've broken the code
  // into functions. However it is also horribly inefficient because
  // we are repeatedly converting numbers between "standard" and "array"
  // formats, and incurring performance penalties due to this

  private int arrayToInteger(int[] input) {
    String s = "";
    for (int x : input) {
      s = s + String.valueOf(x);
    }
    return Integer.valueOf(s);
  }

  private int[] integerToArray(int input) {
    String tempString = String.valueOf(input);
    int[] nArray = new int[tempString.length()];
    for (int i = 0; i < nArray.length; i++) {
      char tempChar = tempString.charAt(i);
      nArray[i] = Integer.valueOf(String.valueOf(tempChar));
    }
    return nArray;
  }

  private int computeSumOfSquares(int input) {
    int[] temp = integerToArray(input);
    int sum = 0;
    for (int i = 0; i < temp.length; i++) {
      sum = sum + (temp[i] * temp[i]);
    }
    return sum;
  }

  public boolean isHappy(int n) {
    Set<Integer> tried = new HashSet<>();
    tried.add(n);
    while (n != 1) {
      n = computeSumOfSquares(n);
      // Check for cycle
      if (tried.contains(n)) return false;
      // Add n to tried
      tried.add(n);
    }
    return true;
  }
}
