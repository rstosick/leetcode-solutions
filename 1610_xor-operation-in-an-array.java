class Solution {
  public int xorOperation(int n, int start) {
    int xor = 0;
    int temp; // not strictly necessary but this seems to optimize memory usage
    for (int i = 0; i < n; i++) {
      temp = start + 2 * i; // not strictly necessary but this seems to optimize memory usage
      xor = xor ^ (temp);
    }
    return xor;
  }
}
