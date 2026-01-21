class Solution {

    private static final int[][] directions = {
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1},
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n<1) throw new IllegalArgumentException("invalid grid size");
        if(grid[0].length!=n) throw new IllegalArgumentException("invalid grid - not square");
        if(grid[0][0]!=0) return -1;
        if(grid[n-1][n-1]!=0) return -1;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>(); // each array: [x, y, distance]
        
        // Starting on the first cell will count as a step
        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1});

        // Travel using BFS
        while(queue.isEmpty()==false) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            if(x==n-1 && y==n-1) return distance;
            for(int[] travel: Solution.directions) {
                // Compute new coordinates
                int newX = x + travel[0];
                int newY = y + travel[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                else {
                    // check if this cell can be traveled to
                    boolean validPath = (grid[newX][newY]==0);
                    if(validPath==true && visited[newX][newY]==false) {
                        visited[newX][newY]=true;
                        queue.add(new int[]{newX, newY, distance+1});
                    }
                }
            }
        }

        return -1;
    }
}