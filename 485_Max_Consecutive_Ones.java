class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        if(length==0) {
            System.out.println("Illegal argument");
            return -1;
        }
        int currentConsecutive = 0;
        int maxConsecutive = 0;
        for(int i=0; i<length; i++) {
            if(nums[i] == 1) {
                currentConsecutive++;
            } else {
                currentConsecutive = 0;
            }
            if(currentConsecutive > maxConsecutive) {
                maxConsecutive = currentConsecutive;
            }
        }
        return maxConsecutive;
    }
    
}
