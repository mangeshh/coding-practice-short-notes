import java.util.LinkedList;

class TNodde {

    char data;
    TNodde rNode;
    TNodde lNode;

    TNodde(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setRNode(TNodde node) {
        this.rNode = node;
    }

    public void setLNode(TNodde node) {
        this.lNode = node;
    }

}

public class TreeVerticalOrder {

    public static TNodde buildTree() {
        TNodde t1 = new TNodde('a');
        TNodde t2 = new TNodde('b');
        TNodde t3 = new TNodde('c');
        TNodde t4 = new TNodde('d');
        TNodde t5 = new TNodde('e');
        TNodde t6 = new TNodde('f');
        TNodde t7 = new TNodde('g');
        TNodde t8 = new TNodde('h');
        TNodde t9 = new TNodde('i');
        TNodde t10 = new TNodde('j');
        TNodde t11 = new TNodde('k');
        TNodde t12 = new TNodde('l');
        TNodde t13 = new TNodde('m');
        TNodde t14 = new TNodde('n');
        TNodde t15 = new TNodde('p');
        TNodde t16 = new TNodde('q');

        t1.setLNode(t2);
        t1.setRNode(t3);

        t2.setLNode(t4);
        t2.setRNode(t5);

        t3.setLNode(t6);
        t3.setRNode(t7);

        t4.setLNode(t8);
        t4.setRNode(t9);

        t6.setLNode(t10);
        t6.setRNode(t11);

        t7.setRNode(t3);

        t9.setLNode(t13);
        t9.setRNode(t14);

        t11.setLNode(t15);
        t11.setRNode(t16);
        return t1;
    }


    public static void printV(TNodde node, int hd, LinkedList<TNodde> list) {

        if (node == null) return;
        if (list.isEmpty()) return;


        while(!list.isEmpty()){

            TNodde t = list.poll();
            System.out.println("size " + list.size());
            int rootCounter = hd;

            if (t.lNode != null) {
                TNodde n1 = t.lNode;
                System.out.println("hd [" + (rootCounter - 1) + "] & data[" + node.data + "]");
                list.add(n1);

            }

            if (t.rNode != null) {
                TNodde n2 = t.rNode;
                System.out.println("hd [" + hd++ + "] & data[" + node.data + "]");
                list.add(n2);
            }


        }

    }

    public static void main(String[] args) {
        TNodde node = buildTree();
        LinkedList queue = new LinkedList<>();
        queue.add(node);
        printV(node, 0, queue);
    }

}
