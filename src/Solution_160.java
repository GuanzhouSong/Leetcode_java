public class Solution_160 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int A = 0, B = 0;
    ListNode hA = headA;
    ListNode hB = headB;
    while (hA != null) {
      A++;
      hA = hA.next;
    }
    while (hB != null) {
      B++;
      hB = hB.next;
    }
    hA = headA;
    hB = headB;
    int diff;
    if (A > B) {
      diff = A - B;
      while (diff > 0) {
        hA = hA.next;
        diff--;
      }
    } else {
      diff = B - A;
      while (diff > 0) {
        hB = hB.next;
        diff--;
      }
    }
    while (hA != null && hB != null) {
      if (hA.equals(hB)) {
        return hA;
      }
      hA = hA.next;
      hB = hB.next;
    }
    return null;
  }
}
