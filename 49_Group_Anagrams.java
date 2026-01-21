class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String s: strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);
            List<String> originals = anagrams.get(key);
            if(originals==null) {
                originals = new ArrayList<>();
                anagrams.put(key, originals);
            }
            originals.add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(String s: anagrams.keySet()) {
            List<String> sublist = anagrams.get(s);
            result.add(sublist);
        }
        return result;
    }
}