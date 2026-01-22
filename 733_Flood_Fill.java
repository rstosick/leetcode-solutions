class Solution {

  private static final int[][] VALID_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean validBounds(int[][] image, int sr, int sc) {
    if (sr < 0 || sc < 0) return false;
    if (sr >= image.length) return false;
    if (sc >= image[0].length) return false;
    return true;
  }

  private void dfs(
      int[][] image, boolean[][] visited, int sr, int sc, int startColor, int targetColor) {
    if (!validBounds(image, sr, sc)) return;
    if (visited[sr][sc]) return;
    if (image[sr][sc] != startColor) return;
    visited[sr][sc] = true;
    image[sr][sc] = targetColor;
    for (int[] direction : VALID_DIRECTIONS) {
      dfs(image, visited, sr + direction[0], sc + direction[1], startColor, targetColor);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    int startColor = image[sr][sc];
    int targetColor = color;
    dfs(image, visited, sr, sc, startColor, targetColor);
    return image;
  }
}
