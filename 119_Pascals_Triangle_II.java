// Per Wikipedia:
// The triangle may be constructed in the following manner:
// In row 0 (the topmost row), there is a unique nonzero entry 1.
// Each entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right,
// treating blank entries as 0. 

class Solution {
    private int safeValue(Integer[] array, int index) {
        // In Pascal's triangle, we can treat non-existent values as zero
        int output = 0;
        if(index<0) output = 0;
        else if(index>=array.length) output = 0;
        else output=array[index];
        // System.out.printf("Debug: array.length=%d, index=%d, safeValue=%d\n", array.length, index, output);
        return output;
    }
    
    public List<Integer> getRow(int rowIndex) {
        Integer[] previousRow = new Integer[1];
        previousRow[0] = 1;
        Integer[] currentRow;
        for(int n=1;n<=rowIndex;n++) {
            // System.out.printf("Debug: Outer loop: n=%d, rowIndex=%d\n", n, rowIndex);
            // The size of the nth row will be n+1
            currentRow = new Integer[n+1];
            currentRow[0] = 0;
            // System.out.printf("Debug: Outer loop: n=%d, currentRow.length=%d\n", n, currentRow.length);
            for(int j=0;j<currentRow.length;j++) {
                currentRow[j] = safeValue(previousRow, j-1) + safeValue(previousRow, j);
            }

            previousRow = currentRow; // this was backwards and took me 30 minutes to find :-(
        }
        return Arrays.asList(previousRow);
    }
}