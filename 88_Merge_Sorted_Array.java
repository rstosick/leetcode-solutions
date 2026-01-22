class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1copy = new int[m];
        for(int i=0; i<nums1copy.length; i++) {
            nums1copy[i] = nums1[i];
        }
        int nums1ptr = 0;
        int nums2ptr = 0;
        boolean shouldCopyFrom1; // true: copy from nums1copy, false copy from nums2
        for(int i=0; i<m+n;i++) {
            
            // Decide whether to FROM nums1copy or nums2
            if(nums1ptr>=m) shouldCopyFrom1 = false;
            else if(nums2ptr>=n) shouldCopyFrom1 = true;
            else if(nums1copy[nums1ptr]<nums2[nums2ptr]) shouldCopyFrom1 = true;
            else shouldCopyFrom1 = false;
            // System.out.printf("i=%d, shouldCopyFrom1=%b\n", i, shouldCopyFrom1);

            if(shouldCopyFrom1==true) {
                nums1[i] = nums1copy[nums1ptr];
                nums1ptr++;
            } else {
                nums1[i] = nums2[nums2ptr];
                nums2ptr++;
            }
        }
    }
}