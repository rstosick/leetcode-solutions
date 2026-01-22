class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        if(nums[0]!=nums[1]) {
            if(nums[1]==nums[2]) return nums[0];
            else return nums[1];
        }
        if(nums[nums.length-1]!=nums[nums.length-2]) {
            // If the last element is not equal to the 2nd to last element
            if(nums[nums.length-2]==nums[nums.length-3]) return nums[nums.length-1];
            else return nums[nums.length-2];
        }
        for(int i=0; i<nums.length-1; i=i+2) {
            if(nums[i]!=nums[i+1]) {
                if(nums[i]==nums[i-1]) return nums[i+1];
                else return nums[i];
            }
        }
        return -999;
    }
}