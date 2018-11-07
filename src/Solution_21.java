class Solution_21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    while (cur1 != null && cur2 != null) {
      ListNode temp;
      if (cur1.val < cur2.val) {
        temp = new ListNode(cur1.val);
        cur1 = cur1.next;
      } else {
        temp = new ListNode(cur2.val);
        cur2 = cur2.next;
      }
      cur.next = temp;
      cur = cur.next;
    }
    if(cur1 != null){
      cur.next = cur1;
    }
    if(cur2 != null){
      cur.next = cur2;
    }
    return dummy.next;
  }
}