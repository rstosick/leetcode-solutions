/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {

  // public boolean checkListEquality(ListNode headA, ListNode headB) {
  //     ListNode aPointer = headA;
  //     ListNode bPointer = headB;
  //     while(aPointer.next!=null) {
  //         if(aPointer!=bPointer) {
  //             // I think Leetcode's custom judge may have a bug
  //             // This condition used to be aPointer.val!=bPointer.val, but it consistently failed
  // tests
  //             // Once I changed it to aPointer!=bPointer, it started passing
  //             return false;
  //         }
  //         if(aPointer.next!=bPointer.next) {
  //             return false;
  //         }
  //         aPointer = aPointer.next;
  //         bPointer = bPointer.next;
  //     }
  //     return true;
  // }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode slow = headA;
    ListNode fast = headB;

    // Start with the slow list (A). Check the first node of it,
    // and check it against the first, 2nd, 3rd node of the "fast" list
    // until we find two equal nodes.
    // Once we have found two equal nodes, we will need to  mark that point as "intersect",
    // then check if the remaining nodes are all equal. If so, we return intersect
    // If not, we advance the slow list by 1, reset the fast pointer to the head, and repeat the
    // process

    while (slow != null) {
      fast = headB; // reset the fast pointer
      while (fast != null) {
        boolean isEqual = (slow == fast);
        if (isEqual) {
          return slow; // slow==fast here so return either :-)
        } else {
          fast = fast.next;
        }
        ;
      }
      slow = slow.next; // increment the slow pointer
    }

    // If we haven't found anything, then return null
    return null;
  }
}
