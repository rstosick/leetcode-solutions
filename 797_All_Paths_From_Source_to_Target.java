class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> solution = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        queue.add(temp);
        int target = graph.length-1;

        while(queue.isEmpty()==false) {
            List<Integer> currentPath = queue.remove();

            // Get the current node
            int currentNode = currentPath.get(currentPath.size()-1);

            // Check if we've reached the target
            if(currentNode==target) {
                solution.add(currentPath);
                continue;
            }

            // Check all neighbors of the current node
            // See which ones are visited
            // For the unvisited ones, create a new path and add it to the queue
            int[] edges = graph[currentNode];
            for(int nextNode: edges) {
                List<Integer> newPath = new ArrayList<>();
                newPath.addAll(currentPath);
                newPath.add(nextNode);
                queue.add(newPath);
            }
        }
        return solution;

    }
}