class Solution {
  public int[] decrypt(int[] code, int k) {
    System.out.printf("k=%d\n", k);
    int n = code.length;
    int[] output = new int[code.length];

    // We can't use equality (< or >) in a case statement
    if (k > 0) {
      for (int i = 0; i < code.length; i++) {
        int sum = 0;
        for (int j = i + 1; j <= i + k; j++) {
          sum = sum + code[j % n];
        }
        output[i] = sum;
      }
    } else if (k < 0) {
      // If k < 0, replace the ith number with the sum of the previous k numbers.
      int newK = Math.abs(k);
      for (int i = 0; i < code.length; i++) {
        int sum = 0;
        for (int j = i - 1; j >= i - newK; j--) {
          int position = j % n;
          if (position < 0) position = (code.length) + position;
          sum = sum + code[position];
        }
        output[i] = sum;
      }
    } else {
      // The array is already initialized to zero?
      // If k == 0, replace the ith number with 0.
      // for(int i=0; i<code.length; i++) {
      //     output[i] = 0;
      // }
    }
    return output;
  }
}
