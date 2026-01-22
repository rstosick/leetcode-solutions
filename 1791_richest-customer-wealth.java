class Solution {
  public int maximumWealth(int[][] accounts) {
    int maxWealth = 0; // possible edge case - what if all customers are in debt (negative wealth)?
    int numBanks = accounts[0].length;
    int numCustomers = accounts.length;
    for (int i = 0; i < numCustomers; i++) {
      int currentCustomerWealth = 0;
      // Sum up how much the current customer has
      // Compare it to maxWealth
      // If it's larger, overwrite maxWealth

      // Approach 1: Use a for loop
      for (int j = 0; j < numBanks; j++) {
        // Check all the accounts for a particular customer
        currentCustomerWealth = currentCustomerWealth + accounts[i][j];
      }

      // Approach 2: Use Java library
      // However this may be slower
      // currentCustomerWealth = Arrays.stream(accounts[i]).sum();

      if (currentCustomerWealth > maxWealth) {
        maxWealth = currentCustomerWealth;
      }
    }
    return maxWealth;
  }
}
