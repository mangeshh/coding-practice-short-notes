import java.util.Stack;


public class SolutionReverseList {

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();

        while (head != null) {
            ListNode ref = head.next;
            head.next = null;
            stack.push(head);
            head = ref;
        }

        ListNode root = stack.pop();
        ListNode current = root;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            current.next = temp;
            current = temp;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode temp = reverseList(l1);
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}