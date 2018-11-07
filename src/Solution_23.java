import java.util.Arrays;

public class Solution_23 {
  public ListNode mergeKLists(ListNode[] lists) {
    return recursive(lists);
  }

  private ListNode recursive(ListNode[] lists){
    if(lists.length ==0){
      return null;
    }
    if(lists.length==1){
      return lists[0];
    }
    int mid = lists.length/2;
    ListNode[] l = Arrays.copyOfRange(lists,0,mid+1);
    ListNode[] r = Arrays.copyOfRange(lists,mid+1,lists.length);
    return mergeTwoLists(recursive(l),recursive(r));
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
