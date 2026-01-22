class Solution {
  public int subtractProductAndSum(int n) {

    // Doing a char array probably increases memory usage slightly,
    // as the JVM must store both a String and a char array simultaneously
    // However an array is much faster to iterate over than using String.getCharAt()
    // We see a near-perfect runtime: 0 ms, beats 100.00% of solutions
    char[] digits = String.valueOf(n).toCharArray();

    int length = digits.length;
    int sum = 0;
    int product = 1;
    int temp;
    for (int i = 0; i < length; i++) {
      temp = Character.getNumericValue(digits[i]);
      sum = sum + temp;
      product = product * temp;
    }
    return product - sum;
  }
}
