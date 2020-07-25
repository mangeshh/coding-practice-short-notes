public class SolutionDeleteListElement {

    public static int length(ListNode n) {
        int i = 0;
        while (n != null) {
            n = n.next;
            i++;
        }
        return i;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int j = length(head);
        int reference = j - n;
        int counter = 0;
        ListNode current = head;
        ListNode prev = null;

        if(reference == 0){
            return head.next;
        }

        while (counter < reference) {
            prev = current;
            current = current.next;
            counter++;
        }

        if(prev == null){
            return null;
        }

        ListNode elementTObeDeleted = prev.next;
        prev.next = elementTObeDeleted.next;
        elementTObeDeleted.next = null;


        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        //l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        removeNthFromEnd(l1, 2);
    }
}