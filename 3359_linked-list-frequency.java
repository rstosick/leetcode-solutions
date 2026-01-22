/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode frequenciesOfElements(ListNode head) {
    Map<Integer, Integer> frequency = new HashMap<>();
    ListNode pointer = head;
    while (pointer != null) {
      // Check if the value is in the Map
      // If so, update the frequency, if not then add it
      // Then advance the pointer
      if (frequency.containsKey(pointer.val)) {
        frequency.replace(pointer.val, frequency.get(pointer.val), frequency.get(pointer.val) + 1);
      } else {
        frequency.put(pointer.val, 1);
      }
      pointer = pointer.next;
    }
    System.out.println(frequency);

    ListNode output = new ListNode(0);
    ListNode outputPointer = output;
    ListNode outputPointerPrevious = null;

    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
      outputPointer.val = entry.getValue();
      outputPointer.next = new ListNode(0);
      outputPointerPrevious = outputPointer;
      outputPointer = outputPointer.next;
    }
    outputPointerPrevious.next = null;

    return output;
  }
}
