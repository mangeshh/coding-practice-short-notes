class LNode {
    int data;
    LNode mNext;
    LNode sNext;

    LNode(int data) {
        this.data = data;
    }

}

@SuppressWarnings("unused")
public class LinkedStack {

    LNode mHead = null;
    LNode sHead = null;

    public void insertNode(LNode lNode) {
        LNode current = mHead;
        LNode prev = null;

        while (current.data < lNode.data) {
            prev = current;
            current = current.mNext;
        }

        if (prev != null) {
            prev.mNext = lNode;
        }

        lNode.mNext = current;

        if (mHead.data > lNode.data) {
            mHead = lNode;
        }
    }

    public void removeNode(LNode lNode) {
        LNode current = mHead;
        LNode prev = null;

        while (current != null) {
            prev = current;

            if (current.data == lNode.data) {
                break;
            }
            current = current.mNext;
        }

        prev.mNext = current.mNext;

     }

    public void add(LNode lNode) {
        if (mHead == null) {
            mHead = lNode;
            sHead = lNode;
        } else {
            insertNode(lNode);
            sHead.sNext = lNode;
        }
    }

    public void pop() {
        LNode temp = sHead;
        removeNode(sHead);
        sHead = temp.sNext;
        temp = null;
    }

    public static void main(String[] args) {
        LNode l1 = new LNode(10);
        LNode l2 = new LNode(5);
        LNode l3 = new LNode(2);
        LinkedStack ls = new LinkedStack();
        ls.add(l1);
        ls.add(l3);
        ls.add(l2);
    }
}
