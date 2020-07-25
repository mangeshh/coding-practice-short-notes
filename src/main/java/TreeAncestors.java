import java.util.Arrays;

class DNode {

    int data;
    DNode next;
    DNode prev;

    public DNode(int data, DNode next, DNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
        if(prev != null)
        prev.next = this;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}

class TNodeX {
    int data;
    TNodeX left;
    TNodeX right;

    public TNodeX(int data) {
        this.data = data;
    }

    public TNodeX(int data, TNodeX left, TNodeX right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


}

/**
 *           1
 *      2         3
 *  4      5    6     7
 **/
@SuppressWarnings("unused")
public class TreeAncestors {

    public static void main(String[] args) {
        TNodeX t4 = new TNodeX(4);
        TNodeX t5 = new TNodeX(5);
        TNodeX t2 = new TNodeX(2, t4, t5);
        TNodeX t6 = new TNodeX(6);
        TNodeX t7 = new TNodeX(7);
        TNodeX t3 = new TNodeX(3, t6, t7);
        TNodeX t1 = new TNodeX(1, t2, t3);

        convert(t1, null);
    }

    public static void main1(String[] args) {
        TNodeX t4 = new TNodeX(4);
        TNodeX t5 = new TNodeX(5);
        TNodeX t2 = new TNodeX(2, t4, t5);
        TNodeX t6 = new TNodeX(6);
        TNodeX t7 = new TNodeX(7);
        TNodeX t3 = new TNodeX(3, t6, t7);
        TNodeX t1 = new TNodeX(1, t2, t3);

        //print(t1, 1);
        int[] arr = new int[3];
        //printAncestor(t1, 0, arr );
        System.out.println(getLevelOfNode(t1, 2, 0));
    }

    public static DNode convert(TNodeX t, DNode dNode) {
        if (t == null) return null;
        DNode prev = convert(t.left, dNode);
        DNode d = new DNode(t.data, null, prev);
        if(dNode!= null){
           dNode.setNext(d);
        }
        return convert(t.right, d);
    }

    public static boolean printAncestor(TNodeX x, int num) {

        if (x == null) return false;

        if (num == x.data) {
            System.out.println(x.data);
            return true;
        }

        if (printAncestor(x.left, num) || printAncestor(x.right, num)) {
            System.out.println(x.data);
            return true;
        }
        return false;
    }

    public static int getLevelOfNode(TNodeX root, int val, int level) {

        if (root == null)
            return 0;

        if (root.data == val)
            return level;

        int result = getLevelOfNode(root.left, val, level + 1);

        if (result != 0) {
            return result;
        }
        return getLevelOfNode(root.right, val, level + 1);

    }

    /**
     * 1
     * 2         3
     * 4      5   6       7
     **/
    public static void printPath(TNodeX x, int index, int[] arr) {

        if (x == null) {
            return;
        }
        if (x.left == null && x.right == null) {
            arr[index] = x.data;
            System.out.println(Arrays.toString(arr));
        }

        arr[index++] = x.data;
        printPath(x.left, index, arr);
        printPath(x.right, index, arr);

    }
}
