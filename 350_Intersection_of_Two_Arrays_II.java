class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            int curr = nums1[i];
            if(map1.get(curr)==null)
            {
                map1.put(curr,1);
            }
            else
            {
                map1.put(curr,map1.get(curr)+1);    
            }
        }
        
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int i=0;i<nums2.length;i++)
        {
            int curr = nums2[i];
            if(map2.get(curr)==null)
            {
                map2.put(curr,1);
            }
            else
            {
                map2.put(curr,map2.get(curr)+1);    
            }
        }
        
        for(Integer i: map1.keySet())
        {
            int qty1 = map1.get(i);
            int qty2 = 0;
            if(map2.get(i)!=null)
            {
                qty2 = map2.get(i);
            }
           int qty = Math.min(qty1,qty2);
            for(int j=0;j<qty;j++)
            {
                list.add(i);
            }
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
        
    
    }
}