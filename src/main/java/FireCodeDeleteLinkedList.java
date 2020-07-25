@SuppressWarnings("unused")
public class FireCodeDeleteLinkedList {


    public static ListNode deleteAtHead(ListNode head) {

        ListNode current = head.next;
        ListNode previous = new ListNode(-1);

        while (head != current) {
            System.out.println("head is " + head.val);
            System.out.println(current.val);
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        head = current.next;
        current.next = null;
        return head;
    }

    public static ListNode deleteAtMiddle(ListNode head, int position) {

        if (head == null) return head;
        ListNode current = new ListNode(-1);
        ListNode ref = current;
        current.next = head;
        ListNode previous = null;

        for (int i = 1; i <= position; i++) {
            if (current == null) break;
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }
        return ref.next;

    }

    public static ListNode build() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        return l1;

    }


    public static ListNode circularBuild() {
        ListNode ref;
        ListNode l1 = new ListNode(1);
        ref = l1;
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l1;

        return ref;

    }

    public static void main1(String[] args) {
        ListNode l1 = build();
        System.out.println(deleteAtMiddle(l1, 5));
    }

    public static void main(String[] args) {
        ListNode l1 = circularBuild();
        deleteAtHead(l1);
    }
}
