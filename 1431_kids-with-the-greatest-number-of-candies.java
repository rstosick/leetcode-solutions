class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    // We could just initialize this to zero and let the loop handle setting the value
    // However explicitly initializing it here will ensure we could handle hypothetical
    // negative values of candies, i.e. if a kid owes someone candy
    int max = candies[0];

    // We don't need to check candies[0] but this loop construct is simple
    // and avoids the need to iterate manually through the array

    for (int count : candies) {
      if (count > max) {
        max = count;
      }
    }

    // We could initialize this as a List<Boolean> but arrays have good performance
    // We can convert the entire resulting array to a list all at once for
    // best performance. In terms of memory usage, 2*O(n) is still O(n), and
    // in practice booleans use negligible memory except for massive data sets
    Boolean[] greatestCandies = new Boolean[candies.length];

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] + extraCandies >= max) {
        greatestCandies[i] = true;
      } else {
        greatestCandies[i] = false;
      }
    }

    // Convert to the format requested
    return Arrays.asList(greatestCandies);
  }
}
