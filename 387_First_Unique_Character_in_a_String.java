class Solution {
    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: str)
        {
            if(map.containsKey(c)==false)
            {
                map.put(c,1);
            }
            else
            {
                map.put(c,map.get(c)+1);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            if(map.get(str[i])==1)
            {
                return i;
            }
        }
        return -1;
    }
}
