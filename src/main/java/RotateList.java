public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(length(head) < k){
            k = k  % length(head);
        }
        return rotate(head, k);
    }

    public static void printList(ListNode elem){
        while(elem!=null){
            System.out.println(elem.val);
            elem = elem.next;
        }
    }

    public static int length(ListNode elem){
        int  cnt = 0;
        while(elem!=null){
            cnt++;
            elem = elem.next;
        }
        return cnt;
    }

    public static ListNode rotate(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = temp;

        if(k ==0){
            printList(head);
            return head;
        }

        while (temp != null && temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = head;
        head = temp;

        return rotateRight(head, --k);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        rotateRight(n1, 2);
    }
}