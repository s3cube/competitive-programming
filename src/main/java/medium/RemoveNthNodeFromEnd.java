package medium;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
//        one.next.next = new ListNode(3);
//        one.next.next.next = new ListNode(4);
//        one.next.next.next.next = new ListNode(5);
        new RemoveNthNodeFromEnd().removeNthFromEnd(one, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(-1);
        ListNode slow = start, fast = start;
        start.next = head;

        for (int i = 0; i < n ; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;

    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
