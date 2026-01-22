class Solution {
  public int calPoints(String[] operations) {
    int[] scores = new int[operations.length];
    int scoresIndex = 0;
    for (String op : operations) {
      if (op.equals("+")) {
        // handle the + case
        int tempOnePrevious = scores[scoresIndex - 1];
        int tempTwoPrevious = scores[scoresIndex - 2];
        int newScore = tempOnePrevious + tempTwoPrevious;
        scores[scoresIndex] = newScore;
        scoresIndex++;
      } else if (op.equals("D")) {
        // handle the D case
        // theoretically this temp is not needed but it keeps the code cleaner
        int temp = scores[scoresIndex - 1];
        scores[scoresIndex] = 2 * temp;
        scoresIndex++;
      } else if (op.equals("C")) {
        // handle the C case
        // void out the score
        // WARNING: If invalid input is passed, this will likely
        // cause an unhandled out of bounds exception, i.e. if the very
        // first operation is C, or no scores have been recorded yet
        scoresIndex--;
        scores[scoresIndex] = 0;
      } else {
        // WARNING: This will throw an unhandled exception if any invalid
        // input has been passed into the function
        int value = Integer.valueOf(op);
        scores[scoresIndex] = value;
        scoresIndex++;
      }
    }
    int sum = 0;
    for (int x : scores) {
      sum = sum + x;
    }
    return sum;
  }
}
