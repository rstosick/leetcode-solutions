class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int flipped = 0;
        int slow = 0;
        int fast = 0;
        while(fast<nums.length) {
            if(nums[fast]!=1) flipped++;
            
            // Shrink window by moving rightward
            while(flipped > k) {
                if(nums[slow]!=1) flipped--;
                slow++;
            }
            if(fast-slow+1>max) {
                max = fast-slow+1;
            }
            // max = Integer.max(max, (fast-slow)+1);
            // end
            fast++;
        }
        return max;
    }
}