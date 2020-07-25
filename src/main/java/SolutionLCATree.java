public class SolutionLCATree {
    /**
     * Definition for a binary tree graph.node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public boolean find(TreeNode t, TreeNode v) {

        if (t == null) {
            return false;
        }
        if (t.val == v.val) {
            return true;
        }

        find(t.left, v);
        find(t.right, v);
        return false;
    }


}