class Solution {
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 1; i < numbers.length + 1; i++) {
      int val = numbers[i - 1];
      List<Integer> positions = map.get(val);
      if (positions == null) {
        positions = new ArrayList<>();
        map.put(val, positions);
      }
      positions.add(i);
    }
    for (Integer current : map.keySet()) {
      int complement = target - current;
      List<Integer> currentPositions = map.get(current);
      if (complement == current) {
        if (currentPositions.size() >= 2) {
          int[] output = new int[] {currentPositions.get(0), currentPositions.get(1)};
          Arrays.sort(output);
          return output;
        } else continue;
      }
      List<Integer> complementPositions = map.get(complement);
      if (complementPositions == null) continue;
      else {
        int[] output = new int[] {currentPositions.get(0), complementPositions.get(0)};
        Arrays.sort(output);
        return output;
      }
    }
    return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
  }
}
