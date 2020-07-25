import java.util.Stack;

public class SolutionMergeKList {

    public ListNode merge(ListNode listA, ListNode listB) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (listA != null || listB != null) {
            if (listA == null) {
                current.next = new ListNode(listB.val);
                listB = listB.next;
            } else if (listB == null) {
                current.next = new ListNode(listA.val);
                listA = listA.next;
            } else if (listA.val <= listB.val) {
                current.next = new ListNode(listA.val);

                listA = listA.next;
            } else if (listB.val < listA.val) {
                current.next = new ListNode(listB.val);
                listB = listB.next;
            }

            current = current.next;

        }

        return head.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        Stack<ListNode> stack = new Stack();

        for (int i = lists.length-1; i >=0 ; i--) {
            stack.push(lists[i]);
        }

        ListNode tempList = stack.pop();

        while (!stack.isEmpty()) {

            ListNode mergeList = merge(tempList, stack.pop());
            tempList = mergeList;
        }

        return tempList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(6);
        ListNode l14 = new ListNode(7);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        l21.next = l22;

        ListNode[] list = new ListNode[]{l1, l11};

        SolutionMergeKList obj = new SolutionMergeKList();
        obj.mergeKLists(list);
    }
}
