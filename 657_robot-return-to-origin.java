class Solution {
  public boolean judgeCircle(String moves) {
    int leftRight = 0;
    int upDown = 0;
    char[] movesArray = moves.toCharArray();
    for (char move : movesArray) {
      switch (move) {
        case 'L':
          leftRight--;
          break;
        case 'R':
          leftRight++;
          break;
        case 'U':
          upDown++;
          break;
        case 'D':
          upDown--;
          break;
        default:
          return false;
      }
    }
    if (leftRight == 0 && upDown == 0) return true;
    return false;
  }
}
