public class SolutionMergeList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = head;

        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val < l2.val){
                    p.next = l1;
                    l1=l1.next;
                }else{
                    p.next=l2;
                    l2=l2.next;
                }
                p = p.next;
            }else if(l1==null){
                p.next = l2;
                break;
            }else if(l2==null){
                p.next = l1;
                break;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode l11 = new ListNode(11);
        ListNode l12 = new ListNode(12);
        ListNode l13 = new ListNode(13);

        l11.next = l12;
        l12.next = l13;

        ListNode mergeList = mergeTwoLists(l1, l11);

        while(mergeList!= null){
            System.out.println(mergeList.val);
            mergeList = mergeList.next;
        }
    }
}
