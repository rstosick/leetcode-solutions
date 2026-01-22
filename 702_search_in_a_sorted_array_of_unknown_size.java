/**
 * // This is ArrayReader's API interface. // You should not implement it, or speculate about its
 * implementation interface ArrayReader { public int get(int index) {} }
 */
class Solution {
  public int search(ArrayReader reader, int target) {
    int lower = 0;
    int upper = 10000 - 1; // 1 <= secret.length <= 10^4, 0-indexed
    int mid = upper + 1; // need to initialize this to a dummy value
    int val = target + 1; // need to initialize this to a dummy value that is greater than target
    while (lower <= upper) {
      mid = lower + (upper - lower) / 2;
      val = reader.get(mid);
      if (val == target) return mid;
      if (val < target) { // we are searching too low in the range
        lower = mid + 1;
      } else {
        upper = mid - 1;
      }
    }
    if (val == target) return mid;
    else return -1;
  }
}
