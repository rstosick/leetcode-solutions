class UnionFind {

    private int[] root;
    private int[] rank;
    private int numRoots;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for(int i=0; i<size;i++) {
            root[i] = i;
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
}

public class FriendshipRecord implements Comparable<FriendshipRecord> {
    public int timestamp;
    public int friendA;
    public int friendB;

    public FriendshipRecord(int timestamp, int friendA, int friendB) {
        this.timestamp = timestamp;
        this.friendA = friendA;
        this.friendB = friendB;
    }
    
    @Override
    public int compareTo(FriendshipRecord other) {
        // Sort chronologically
        // Integer timestamp1 = new Integer(this.timestamp);
        // Integer timestamp2 = new Integer(other.timestamp);    
        // return timestamp1.compareTo(timestamp2);
        if(this.timestamp==other.timestamp) return 0;
        else if(this.timestamp<other.timestamp) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return String.format("time=%d, friendA=%d, friendB=%d", this.timestamp, friendA, friendB);
    }

}


class Solution {
    public int earliestAcq(int[][] logs, int n) {
        int groupCount = n;
        List<FriendshipRecord> recordList = new ArrayList<FriendshipRecord>();
        for(int i=0; i<logs.length; i++) {
            FriendshipRecord newRecord = new FriendshipRecord(logs[i][0], logs[i][1], logs[i][2]);
            recordList.add(newRecord);
        }
        Collections.sort(recordList);
        UnionFind uf = new UnionFind(n);
        for(FriendshipRecord record: recordList) {
            uf.union(record.friendA, record.friendB);
            if(uf.countRoots()==1) {
                return record.timestamp;
            }
        }
        return -1;
    }
}