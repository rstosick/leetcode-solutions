class Solution {

  private static final int[][] VALID_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private static boolean validBounds(int[][] grid, int x, int y) {
    if (x < 0 || y < 0) return false;
    if (y >= grid.length) return false;
    if (x >= grid[0].length) return false;
    return true;
  }

  private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
    if (!validBounds(grid, x, y)) return 0;
    if (visited[y][x] == true) return 0;
    visited[y][x] = true;
    int size = 1;
    if (grid[y][x] == 0) {
      return 0;
    }

    for (int[] direction : VALID_DIRECTIONS) {
      int newX = x + direction[0];
      int newY = y + direction[1];
      size = size + dfs(grid, visited, newX, newY);
    }
    return size;
  }

  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int maxSize = 0;
    int size;
    for (int x = 0; x < grid[0].length; x++) {
      for (int y = 0; y < grid.length; y++) {
        if (visited[y][x] == false) {
          if (grid[y][x] == 1) {
            size = dfs(grid, visited, x, y);
            maxSize = Math.max(maxSize, size);
          }
        }
      }
    }
    return maxSize;
  }
}
