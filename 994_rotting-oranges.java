class Solution {

  private static final int[][] VALID_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  boolean validBounds(int[][] grid, int[] position) {
    int column = position[0];
    int row = position[1];
    if (column < 0 || row < 0) return false;
    if (column >= grid.length) return false;
    if (row >= grid[0].length) return false;
    return true;
  }

  public int orangesRotting(int[][] grid) {
    int fresh = 0;
    int minutes = 0;
    int currentCell;
    Deque<int[]> queue = new ArrayDeque<>();
    for (int column = 0; column < grid.length; column++) {
      for (int row = 0; row < grid[0].length; row++) {
        currentCell = grid[column][row];
        if (currentCell == 1) { // fresh orange
          fresh++;
        } else if (currentCell == 2) { // rotten orange
          // add to queue
          queue.add(new int[] {column, row});
        } else {
          // cell is empty, do nothing
        }
      }
    }

    while (!queue.isEmpty() && fresh > 0) {
      int countToProcess = queue.size(); // per cycle
      boolean rottedThisCycle = false;
      for (int i = 0; i < countToProcess; i++) {
        int[] location = queue.pop();
        for (int[] direction : VALID_DIRECTIONS) {
          int[] newLocation = new int[] {location[0] + direction[0], location[1] + direction[1]};
          if (validBounds(grid, newLocation)) {
            if (grid[newLocation[0]][newLocation[1]] == 1) {
              grid[newLocation[0]][newLocation[1]] = 2;
              fresh--;
              rottedThisCycle = true;
              queue.addLast(newLocation);
            }
          }
        }
      }
      if (rottedThisCycle == true) minutes++;
    }
    if (fresh > 0) return -1;
    else return minutes;
  }
}
