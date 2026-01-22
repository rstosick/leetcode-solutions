class Solution {
    public int maxProfit(int[] prices) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<prices.length; i++) {
            List<Integer> days = map.get(prices[i]);
            if(days==null) {
                days = new ArrayList<Integer>();
                map.put(prices[i], days);
            }
            days.add(i);
        }
        List<Integer> priceList = new ArrayList<>(map.keySet());
        Collections.sort(priceList);

        int maxProfit = 0;

        // Algorithm:
        // Find the lowest and highest prices
        // See if we can make the transaction
        // If not, stick with the lowest price and check the 2nd, 3rd highest price, etc
        // Until we either find a valid sale, or cannot make any sale with that lowest price
        // Then, continue on for the 2nd lowest price, etc.

        for(int i=0; i<priceList.size(); i++) {
            int buyPrice = priceList.get(i);
            int earliestBuyDay = map.get(buyPrice).get(0);
            int latestPossibleBuyDate = priceList.size()-1;

            for(int j=latestPossibleBuyDate; j>=0; j--) {
                int sellPrice = priceList.get(j);
                if(sellPrice-buyPrice<=maxProfit) break;
                else {
                    List<Integer> sellDays = map.get(sellPrice);
                    int latestBuyDay = sellDays.get(sellDays.size()-1);
                    if(latestBuyDay<=earliestBuyDay) {
                        continue;
                    } else {
                        maxProfit = sellPrice-buyPrice;
                        break;
                    }
                }
            }
        }

        // for(Integer buyPrice : priceList) {
        //     int earliestBuyDay = map.get(buyPrice).get(0);

        //     for(int i=priceList.size()-1; i>=0; i--) {
        //         int sellPrice = priceList.get(i);
        //         if(sellPrice-buyPrice<=maxProfit) continue;
        //         else {
        //             List<Integer> sellDays = map.get(sellPrice);
        //             int latestBuyDay = sellDays.get(sellDays.size()-1);
        //             if(latestBuyDay<=earliestBuyDay) continue;
        //             else maxProfit = sellPrice-buyPrice;
        //         }
                
        //     }
        // }

        return maxProfit;
    }
}