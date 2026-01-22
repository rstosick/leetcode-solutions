class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<String>();
        for(int i=1; i<n+1; i++) {
            out.add(fbHelper(i));
        }
        return out;
    }

    private String fbHelper(int n) {
        // takes in 1 particular number
        // determines what to return
        if(n%3 !=0 && n%5 !=0) {
            return String.valueOf(n);
        }
        String out = "";
        if(n%3 == 0) {
            out += "Fizz";
        }
        if(n%5 == 0) {
            out += "Buzz";
        }
        return out;
    }

    private String fbHelperv2(int n) {
        // takes in 1 particular number
        // determines what to return
        if(n%3 !=0 && n%5 !=0) {
            return String.valueOf(n);
        }
        String out = "";
        if(n%3 == 0) {
            out += "Fizz";
        }
        if(n%5 == 0) {
            out += "Buzz";
        }
        return out;
    }
}