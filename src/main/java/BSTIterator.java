import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class BSTIterator {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();
    int size;
    int counter;

    @SuppressWarnings("unused")
    public void buildList(TreeNode root) {
        if (root == null) {
            return;
        }

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                counter++;
                root = stack.pop();
                if(counter == k){
                    return root.val;
                }
                list.add(root.val);
                root = root.right;
            }
        }

        return -99999;
    }

    public BSTIterator(TreeNode root) {
        //buildList(root);
        //size = list.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(counter++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
       if(counter < size){
           return true;
       }
       return false;
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        BSTIterator itr = new BSTIterator(t1);
        itr.kthSmallest(t1, 4);
       /* while(itr.hasNext()){
            System.out.println(itr.next());
        }*/
    }
}