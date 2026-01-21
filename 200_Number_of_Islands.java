class UnionFind {

    private int[] root;
    private int[] rank;
    private int numRoots;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            // root[i] = -1;
            // rank[i] = 1;
        }
        Arrays.fill(rank, 1);
        numRoots = size;
    }

    public int find(int x) {
        // if (root[x] == -1) return -1;
        if (x == root[x])
            return x;
        else
            return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        // if (root[x] != -1) return;
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] = rank[rootX] + 1;
            }
            numRoots--;
        }

    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int countRoots() {
        return numRoots;
    }

    // public int countRoots() {
    //     int count = 0;
    //     for(int i=0; i<root.length; i++) {
    //         if(root[i]==i) count++;
    //     }
    //     return count;
    // }
}


// This solution uses Union Find and is not particularly optimized
// I also wrote a DFS implementation that is more efficient
class Solution {

    private boolean validBounds(char[][] grid, int x, int y) {
        // Per ChatGPT:
        // In Java, a char[][] grid, the first index is the row (Y direction)
        // and the second index is the column (X direction).
        if (y < 0 || x < 0)
            return false;
        if (y >= grid.length)
            return false;
        if (grid.length == 0)
            throw new IllegalArgumentException("empty grid");
        if (x >= grid[0].length)
            return false;
        return true;
    }

    private void explore(char[][] grid, UnionFind uf, int x, int y) {
        // if it's out of bounds, do nothing
        if (!validBounds(grid, x, y))
            return;

        // if it's water, do nothing
        if (grid[y][x] == '0')
            return;

        // We will compute an "index" to represent each
        // possible cell in the grid. The index will be
        // computed by: x*max_X + y;
        // int max_X = grid[0].length;
        int cols = grid[0].length;
        int currentIndex = y * cols + x;

        if (validBounds(grid, x + 1, y)) {
            if (grid[y][x + 1] == '1') {
                int newIndex = (y) * cols + (x+1);
                uf.union(currentIndex, newIndex);
            }
        }

        if (validBounds(grid, x - 1, y)) {
            if (grid[y][x - 1] == '1') {
                int newIndex = (y) * cols + (x-1);
                uf.union(currentIndex, newIndex);
            }
        }

        if (validBounds(grid, x, y + 1)) {
            if (grid[y + 1][x] == '1') {
                int newIndex = (y+1) * cols + (x);
                uf.union(currentIndex, newIndex);
            }
        }

        if (validBounds(grid, x, y - 1)) {
            if (grid[y - 1][x] == '1') {
                int newIndex = (y-1) * cols + (x);
                uf.union(currentIndex, newIndex);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int maxSize = grid.length * grid[0].length;
        UnionFind uf = new UnionFind(maxSize);

        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                explore(grid, uf, x, y);
            }
        }

        // now, count # of water cells
        int waterCount = 0;
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if(grid[y][x]=='0') waterCount++;
            }
        }


        return uf.countRoots() - waterCount;
    }
}