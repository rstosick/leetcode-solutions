class Solution {

    // private static final Set<Character> VOWELS =
    //     Set.of('a', 'e', 'i', 'o', 'u');

    // private static boolean isVowel(char c) {
    //     return VOWELS.contains(c);
    // }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u':
                return true;
            default:
                return false;
        }
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int slow = 0;
        int vowelCount = 0;
        int maxVowels = 0;
        for(int fast = 0; fast<n; fast++) {
            if(isVowel(s.charAt(fast))) vowelCount++;
            while(fast-slow+1>k) {
                char oldChar = s.charAt(slow);
                if(isVowel(oldChar)) {
                    vowelCount--;
                }
                slow++;
            }
            if(vowelCount>maxVowels) maxVowels=vowelCount;
            // maxVowels = Math.max(maxVowels, vowelCount);
        }
        return maxVowels;
    }
}