class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();
    for (int x : nums1) {
      s1.add(x);
    }
    for (int x : nums2) {
      s2.add(x);
    }
    s1.retainAll(s2);
    int[] output = new int[s1.size()];
    int i = 0;
    for (int x : s1) {
      output[i] = x;
      i++;
    }
    return output;
  }
}

class OldSolution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int nums1ptr = 0;
    int nums2ptr = 0;
    Set<Integer> outputSet = new HashSet<>();

    while (nums1ptr < nums1.length) {
      System.out.printf("outer loop: nums1ptr=%d\n", nums1ptr);
      while (nums2ptr < nums2.length) {
        System.out.printf("inner loop: nums2ptr=%d\n", nums1ptr);
        // if(nums1ptr>=nums1.length) {
        //     break;
        // }
        int x = nums1[nums1ptr];
        int y = nums2[nums2ptr];
        if (nums1[nums1ptr] == nums2[nums2ptr]) {
          outputSet.add(nums1[nums1ptr]);
          nums1ptr++;
          nums2ptr++;
        } else if (nums1[nums1ptr] > nums2[nums2ptr]) {
          nums1ptr++;
        } else if (nums1[nums1ptr] < nums2[nums2ptr]) {
          nums2ptr++;
        } else {
          System.out.printf("Uh-oh. Uncaught error.\n");
        }
        // nums2ptr++;
      }
      nums1ptr++;
    }

    int[] outputArray = new int[outputSet.size()];
    int i = 0;
    for (Integer z : outputSet) {
      outputArray[i] = z;
      i++;
    }
    return outputArray;
  }
}
