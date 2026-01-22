class Solution {
    public boolean isPerfectSquare(int num) {
        // Let's handle edge cases first
        if(num<0) return false;
        if(num==0) return true;
        if(num==1) return true;

        // Then let's try to find x such that x^2 = num

        long lower = 2;
        long upper = num/2;
        long mid;
        long guess;

        while(lower<=upper) {
            mid = lower + (upper-lower)/2;
            guess = mid*mid;
            if(guess==num) return true;
            else if(guess<num) {
                // increase the range
                lower = mid+1;
            } else { // square > num
                upper = mid-1;
            }
        }
        return false;
    }
}