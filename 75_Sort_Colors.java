class Solution {

    private void swap(int[] nums, int pos1, int pos2) {
        if(pos1<0 || pos2<0) throw new IllegalArgumentException("negative index");
        if(pos1>=nums.length) throw new IllegalArgumentException("out of bounds pos1");
        if(pos2>=nums.length) throw new IllegalArgumentException("out of bounds pos1");
        int temp = nums[pos2];
        nums[pos2] = nums[pos1];
        nums[pos1] = temp;
    }

    public void sortColors(int[] nums) {
        if(nums.length<=1) return;
        for(int i=0; i<nums.length; i++) {
            // Find the smallest element after i
            int smallestVal = nums[i];
            int indexOfSmallestVal = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]<smallestVal) {
                    smallestVal=nums[j];
                    indexOfSmallestVal=j;
                }
            }
            swap(nums, i, indexOfSmallestVal);
        }
    }
}