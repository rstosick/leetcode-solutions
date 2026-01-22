class Solution {
    public int searchInsert(int[] nums, int target) {
        
        // This check is unnecessary as the loop will handle this condition
        // if(nums.length==0) return 0;
        
        if(target<=nums[0]) return 0;
        int i;
        for(i=1;i<nums.length; i++) {
            if(target>=nums[i-1] && target <=nums[i]) {
                break;
            }
            
        }
        return i;
    }
}