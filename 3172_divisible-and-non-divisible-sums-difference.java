class Solution {
  public int differenceOfSums(int n, int m) {
    int output = 0;
    for (int i = 0; i <= n; i++) {
      if (i % m != 0) output = output + i;
      else output = output - i;
    }
    return output;
  }
}
