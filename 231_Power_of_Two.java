class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false; // Negative numbers can't be a power of 2
        if(n==1) return true; // This is an edge case not handled by my algorith, so we'll check explicitly
        
        // This condition check is not strictly necessary but may save time
        if(n%2!=0) return false; // If n is an odd number, then it's not a power of 2
        
        // Math.log doesn't have any way to compute a log base 2 or custom base
        // Instead, we can compute log2(n) by doing log10(n)/log10(2)
        // I found that trick on Google :-)
        int temp = (int) Math.rint(Math.log(n)/Math.log(2));

        // Let's assume a hypothesis that "n" is indeed a power of two
        // If our hypothesis is true, then 2^log2(n) == n should be true
        // If this equality fails, then n is not a power of 2
        if(Math.pow(2, temp)==n) return true;
        return false;
    }
}