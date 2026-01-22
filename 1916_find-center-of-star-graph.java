class Solution {
  public int findCenter(int[][] edges) {
    // The first int will be the node number
    // The second int will be the number of edges we have counted
    Map<Integer, Integer> edgeCount = new HashMap<>();

    for (int i = 0; i < edges.length; i++) {
      edgeCount.put(edges[i][0], 1 + edgeCount.getOrDefault(edges[i][0], 0));
      edgeCount.put(edges[i][1], 1 + edgeCount.getOrDefault(edges[i][1], 0));
    }
    int totalNodes = edgeCount.size();
    for (var entry : edgeCount.entrySet()) {
      if (entry.getValue() == totalNodes - 1) return entry.getKey();
    }

    // If we got to here, there is an error or we haven't found the center
    return -1;
  }
}
