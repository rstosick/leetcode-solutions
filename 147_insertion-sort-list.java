/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public ListNode insertionSortList(ListNode head) {
    ListNode placeholder = new ListNode(Integer.MIN_VALUE); // we will end up deleting this later
    ListNode inputNext;
    ListNode outputPrev;
    while (head != null) {
      // Backup head.next before editing pointers
      inputNext = head.next;

      int insertVal = head.val;

      outputPrev = placeholder;
      while (outputPrev.next != null && outputPrev.next.val < insertVal) {
        // continue going forward
        outputPrev = outputPrev.next;
      }
      head.next = outputPrev.next;
      outputPrev.next = head;
      head = inputNext;
    }
    return placeholder.next;
  }
}
