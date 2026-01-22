class Solution {
    public int mySqrt(int x) {
        if(x<0) x=Math.abs(x);
        if(x==0) return 0;
        if(x==1) return 1;
        if(x==2) return 1;
        
        long upper = (x/2);
        long lower = 1;
        long mid;
        long square;
        int candidate = 1; // floor

        while(lower<=upper) {
            mid = lower + (upper-lower)/2;
            square = mid*mid;
            if(square==x) return (int) mid;
            if(square>x) {
                // upper range
                upper = mid-1;
            } else {
                // lower range
                lower = mid + 1;
                candidate = (int) mid;
            }
        }
        return candidate;
    }
}