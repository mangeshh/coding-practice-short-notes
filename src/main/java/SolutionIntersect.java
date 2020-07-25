class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class SolutionIntersect {

    static ListNode currentA;
    static ListNode currentB;

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        while (headA != null || headB != null) {

            if (headA == null) {
                if (currentA.val == headB.val) {
                    return currentA;
                }
            } else {
                currentA = headA;
                headA = headA.next;
            }

            if (headB == null) {
                if (currentB.val == headA.val) {
                    return currentB;
                }
            } else {
                currentB = headB;
                headB = headB.next;
            }

            if (currentA.val == currentB.val) {
                return currentA;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);

        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(8);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        System.out.println(getIntersectionNode(l1, l11));
    }
}
