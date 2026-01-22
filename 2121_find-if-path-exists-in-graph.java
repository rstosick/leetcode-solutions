class Solution {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      if (edge.length != 2) throw new IllegalArgumentException("mis-sized input");
      int a = edge[0];
      int b = edge[1];
      graph.computeIfAbsent(a, val -> new HashSet<Integer>()).add(b);
      graph.computeIfAbsent(b, val -> new HashSet<Integer>()).add(a);
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(source);

    // While the queue is not empty
    while (queue.isEmpty() == false) {

      // Get the next element of the queue
      int currentNode = queue.remove();

      // If the current node is the target, we've found our goal
      if (currentNode == destination) return true;

      // Check if the current node is visited
      // If so, skip it and continue
      if (visited[currentNode] == true) continue;

      // If it is not visited, check all its edges
      // Add any nodes that aren't visited to the queue
      // Or, add all edges to the queue
      for (Integer nextNode : graph.get(currentNode)) {
        if (visited[nextNode] == false) {
          queue.add(nextNode);
        }
      }

      // Finally mark the current node as visited
      visited[currentNode] = true;
    }
    return false;
  }
}
