/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public boolean isPalindrome(ListNode head) {
    return isPalindromeHelper1(head);
  }

  public boolean isPalindromeHelper1(ListNode head) {
    if (head == null) return true;
    List<Integer> values = new ArrayList<>();
    ListNode ptr = head;
    while (ptr != null) {
      values.add(ptr.val);
      ptr = ptr.next;
    }
    for (int i = 0; i < values.size(); i++) {
      if (values.get(i) != values.get(values.size() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
