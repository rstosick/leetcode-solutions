class Solution {
  private boolean isAchievableHelper(int x, int num, int maxOps) {
    if (x == num) return true; // no operations needed
    if (maxOps == 0) return false; // if t==0, we can't do any operations

    // let's try a greedy algorithm here
    // we'll try to minimize the absolute value of x-num
    for (int i = 0; i < maxOps; i++) {
      if (x == num) return true; // no-op case

      int absoluteDifference = Math.abs(x - num);
      int tempX;
      int tempNum;
      int newDiff;
      int newX = x;
      int newNum = num;

      // subcase 1: increase both x and num
      // see if we can beat the current absolute difference
      tempX = x + 1;
      tempNum = num + 1;
      newDiff = Math.abs(tempX - tempNum);
      if (newDiff < absoluteDifference) {
        absoluteDifference = newDiff;
        newX = tempX;
        newNum = tempNum;
      }

      // subcase 2: increase x but decrease num
      // see if we can beat the current absolute difference
      tempX = x + 1;
      tempNum = num - 1;
      newDiff = Math.abs(tempX - tempNum);
      if (newDiff < absoluteDifference) {
        absoluteDifference = newDiff;
        newX = tempX;
        newNum = tempNum;
      }

      // subcase 3: decrease x but increase num
      // see if we can beat the current absolute difference
      tempX = x - 1;
      tempNum = num + 1;
      newDiff = Math.abs(tempX - tempNum);
      if (newDiff < absoluteDifference) {
        absoluteDifference = newDiff;
        newX = tempX;
        newNum = tempNum;
      }

      // subcase 4: decrease both x and num
      // We can try all 4 cases, see which produces the smallest absolute value difference
      // and use that
      // see if we can beat the current absolute difference
      tempX = x - 1;
      tempNum = num - 1;
      newDiff = Math.abs(tempX - tempNum);
      if (newDiff < absoluteDifference) {
        absoluteDifference = newDiff;
        newX = tempX;
        newNum = tempNum;
      }

      if (newX == x && newNum == num) {
        // if none of the 4 cases can beat the existing absolute difference
        // then it's hopeless
        return false;
      } else {
        x = newX;
        num = newNum;
      }
    }
    if (x == num) return true;
    return false;
  }

  public int theMaximumAchievableX(int num, int t) {
    int maxTest = ((num + 1) * (t + 1)) - 1; // the highest value we will maxTest
    for (int x = maxTest; x >= 0; x--) {
      if (isAchievableHelper(x, num, t) == true) {
        return x;
      }
    }
    return 0;
  }
}
