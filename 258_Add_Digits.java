class Solution {

    // This solution works but sucks (bad runtime)
    // TODO: Re-solve this

    private int[] conversionHelper(int num) {
        String numString = String.valueOf(num);
        // System.out.printf("conversionHelper input: %d\n", num);        
        int length = numString.length();
        int[] input = new int[length];
        for(int i=0; i<length; i++) {
            char temp = numString.charAt(i);
            input[i] = Integer.valueOf(Character.toString(temp));
        }
        // System.out.printf("conversionHelper output: %s\n", Arrays.toString(input));
        // return input;
        return (int[]) String.valueOf(num).toCharArray();
    }

    private int sumHelper(int[] input) {
        // System.out.printf("sumHelper input: %s\n", Arrays.toString(input));
        int output = 0;
        for(int i=0; i<input.length; i++) {
            output = output + input[i];
        }
        // System.out.printf("sumHelper result: %d\n", output);
        return output;
    }

    public int addDigits(int num) {
        // System.out.printf("input number: %d\n", num);
        int[] individualIntegers = conversionHelper(num);
        int initialSum = sumHelper(individualIntegers);
        int sum = initialSum;
        // System.out.printf("initial sum: %d\n", num);
        while(sum>9) {
            // Try adding the digits again?
            // Convert the current sum to an int array
            int[] temp = conversionHelper(sum);
            sum = sumHelper(temp);
        }
        return sum;
    }
}