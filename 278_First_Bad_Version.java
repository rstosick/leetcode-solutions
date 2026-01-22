/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

// Note from Rob: This question is interesting in that it has a wide variety of real-world
// applications, including but not limited to tracing bad builds, etc.

public class Solution extends VersionControl {

  // Find the lowest BAD version
  public int firstBadVersion(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int knownGood = 0; // low
    int currentGuess; // mid

    while (knownGood < n) {
      currentGuess = knownGood + (n - knownGood) / 2;
      // System.out.printf("knownGood=%d, n=%d, currentGuess=%d, result=%b\n", knownGood, n,
      // currentGuess, result);
      if (isBadVersion(currentGuess)) { // the current guess is defective
        n = currentGuess;
      } else {
        // version "currentGuess" is okay (not defective)
        knownGood = currentGuess + 1;
      }
    }
    return knownGood;
  }
}
