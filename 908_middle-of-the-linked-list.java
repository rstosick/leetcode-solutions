// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
  public ListNode middleNode(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    int length = countLength(head);
    // System.out.printf("Length of the linked list is %d\n", length);
    ListNode ptr = head.next;
    for (int i = 0; i < (length / 2) - 1; i++) {
      ptr = ptr.next;
    }
    return ptr;
  }

  private int countLength(ListNode head) {
    int length = 1;
    ListNode ptr = head.next;
    while (ptr != null) {
      ptr = ptr.next;
      length++;
    }
    // System.out.printf("Length of the linked list is %d\n", length);
    return length;
  }
}
