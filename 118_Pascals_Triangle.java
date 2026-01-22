class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows==0) return list;
        else
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            list.add(temp);
        }
        for(int i=2;i<=numRows;i++)
        {
            // System.out.printf("i=%d\n",i);
            List<Integer> temp = new ArrayList<Integer>();
            List<Integer> prev = list.get(i-2);
            temp.add(0);
            for(int j=0;j<prev.size();j++)
            {
                temp.add(prev.get(j));
            }
            temp.add(0);
            List<Integer> curr = new ArrayList<Integer>();
            for(int k=0;k<i;k++) // this row has k numbers
            {
                curr.add(temp.get(k)+temp.get(k+1));
            }
            list.add(curr);
        }
        return list;
    }
}
