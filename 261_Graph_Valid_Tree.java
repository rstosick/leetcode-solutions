class UnionFind {

    private int[] root;
    private int[] rank;
    private int numRoots;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for(int i=0; i<size;i++) {
            root[i] = i;
            // rank[i] = 1;
        } 
        Arrays.fill(rank, 1); 
        numRoots = size;
    }

    public int find(int x) {
        if(x==root[x]) return x;
        else return root[x]=find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] = rank[rootX] + 1;
            }
            numRoots--;
        }
        
    }
    public boolean connected(int x, int y) {
        return find(x)==find(y);
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

class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<edges.length; i++) {
            int A = edges[i][0];
            int B = edges[i][1];

            // I decided to treat the UnionFind() class as a black box
            // and not modify the version I wrote for previous problems
            // However, we could optimize the code by having the union()
            // function return a boolean instead of being a void, where
            // the boolean tells whether any merge happened
            if(uf.connected(A,B)==true) return false;
            else uf.union(A,B);
        }
        
        // For the below condition:
        if(uf.countRoots()!=1) return false;
        // We could use this check instead at the beginning of the function:
        // if(edges.length!=n-1) return false;
        
        return true;
    }
}