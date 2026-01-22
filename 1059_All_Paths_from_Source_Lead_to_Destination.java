// https://leetcode.com/problems/all-paths-from-source-lead-to-destination/description/

enum State {
  UNVISITED, // we have not started DFS from this node yet
  VISITING, // this node is on the current recursion stack
  GOOD, // all paths from this node are valid and finite
  BAD // at least one path from this node is invalid or infinite
}

class Node {
  private final int val;
  private State state = State.UNVISITED;

  private List<Integer> edges;

  public Node(int val) {
    this.val = val;
    edges = new ArrayList<Integer>();
  }

  public int getVal() {
    return this.val;
  }

  public State getState() {
    return this.state;
  }

  public void setState(State newState) {
    if (newState == null) throw new IllegalArgumentException("null status");
    if (newState == State.UNVISITED) {
      if (this.state != State.UNVISITED) {
        throw new IllegalArgumentException("Invalid status");
      }
    }
    this.state = newState;
  }

  public List<Integer> getEdges() {
    // return Collections.unmodifiableList(this.edges);
    return this.edges;
  }

  public void addEdge(int edge) {
    this.edges.add(edge);
  }
}

class Solution {
  private Map<Integer, Node> nodeMap;
  private int destinationVal;

  private boolean recursiveHelper(int sourceVal) {
    Node currentNode = nodeMap.get(sourceVal);
    if (currentNode.getState() == State.BAD) return false;
    if (currentNode.getState() == State.GOOD) return true;

    // Check for cycles
    if (currentNode.getState() == State.VISITING) {
      currentNode.setState(State.BAD);
      return false;
    }

    List<Integer> edges = currentNode.getEdges();
    if (edges.size() == 0) {
      if (sourceVal == destinationVal) {
        currentNode.setState(State.GOOD);
        return true;
      } else {
        currentNode.setState(State.BAD);
        return false;
      }
    }

    currentNode.setState(State.VISITING);

    for (int currentEdge : edges) {
      boolean goodChild = recursiveHelper(currentEdge);
      if (goodChild == false) {
        currentNode.setState(State.BAD);
        return false;
      }
    }

    currentNode.setState(State.GOOD);
    return true;
  }

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

    // this.nodeMap = new HashMap<Integer, Boolean>();
    this.nodeMap = new HashMap<Integer, Node>();

    for (int i = 0; i < n; i++) {
      this.nodeMap.putIfAbsent(i, new Node(i));
    }

    // Convert this from an array to a list of lists for easier use
    for (int[] edgeSet : edges) {
      if (edgeSet.length != 2) throw new IllegalArgumentException("failed to parse edge");
      Node node0 = this.nodeMap.getOrDefault(edgeSet[0], new Node(edgeSet[0]));
      node0.addEdge(edgeSet[1]);
      nodeMap.put(node0.getVal(), node0);
    }
    this.destinationVal = destination;
    return recursiveHelper(source);
  }
}
