package may;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode currOdd = head;
        ListNode evenStart = head.next;
        ListNode currEven = head.next;


        while(currEven != null && currEven.next!= null) {
            currOdd.next = currEven.next;
            currOdd = currOdd.next;
            currEven.next = currOdd.next;
            currEven = currEven.next;
        }

        currOdd.next = evenStart;
        return head;
    }
}
