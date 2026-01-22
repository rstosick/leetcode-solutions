/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ptr = new ListNode(Integer.MIN_VALUE);
    ListNode head = ptr;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        ptr.next = l1;
        l1 = l1.next;
      } else {
        ptr.next = l2;
        l2 = l2.next;
      }
      ptr = ptr.next;
    }
    if (l1 != null) ptr.next = l1;
    else ptr.next = l2;
    return head.next;
  }
}
