class Solution {
    public void moveZeroes(int[] nums) {
        int fast=0;
        int slow=0;
        int n = nums.length;
        for(; fast<n; fast++) {
            if(nums[fast]!=0) {
                if(fast!=slow) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
    }
}