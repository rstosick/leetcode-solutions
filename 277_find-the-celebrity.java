/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class Solution extends Relation {
  public int findCelebrity(int n) {
    int j;
    boolean isCelebrity;
    for (int i = 0; i < n; i++) {
      // Start by assuming i is indeed the celebrity
      isCelebrity = true;
      for (j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        ;
        if (knows(j, i) == false) {
          // Case: someone doesn't know them
          isCelebrity = false;
          break;
        } else {
          if (knows(i, j) == true) {
            // Case: they know someone else
            isCelebrity = false;
            break;
          }
        }
      }
      if (isCelebrity == true) return i;
    }
    return -1;
  }
}
