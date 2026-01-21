class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int slow = 0;
        int fast = 0;
        Set<Character> window = new HashSet<>();
        char current;
        while(fast<s.length()) {
            current = s.charAt(fast);
            while(window.contains(current)) {
                char leftmost = s.charAt(slow);
                window.remove(leftmost);
                slow++;
            }
            window.add(current);
            longest = Integer.max(longest, window.size());
            fast++;
        }
        return longest;
    }
}