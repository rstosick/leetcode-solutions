class Solution {
  public int[] plusOne(int[] digits) {
    if (digits.length == 0) return new int[0];
    boolean noCarryRoom = true;
    for (int i = 0; i < digits.length; i++) {
      if (digits[i] < 9) {
        noCarryRoom = false;
        break;
      }
    }
    if (noCarryRoom == true) {
      int[] temp = new int[digits.length + 1];
      System.arraycopy(digits, 0, temp, 1, digits.length);
      digits = temp;
    }

    int carryValue = 0;
    if (digits[digits.length - 1] < 9) {
      digits[digits.length - 1] = digits[digits.length - 1] + 1;
      return digits;
    } else {
      carryValue = 1;
    }

    for (int i = digits.length - 1; i >= 0; i--) {
      int temp = digits[i] + carryValue;
      if (temp <= 9 || i == 0) {
        digits[i] = temp;
        carryValue = 0;
        return digits;
      } else {
        digits[i] = 0;
        carryValue = temp - 9;
      }
    }
    return digits;
  }
}
