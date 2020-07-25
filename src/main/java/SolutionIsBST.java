class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class SolutionIsBST {

    public static String getLevel(String s) {
        s = s + s + s;
        return s;
    }

    public static String space(int i) {
        String s = " ";
        for (int k = 0; k < i; k++) {
            s = s + " ";
        }
        return s;
    }

    public static boolean isValidBST(String level, TreeNode root, long min, long max) {
        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + " >> isValidBST(" + root + ", " + min + ", " + max + ")");


        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(space(level.length()), root.left, min, root.val) &&
                isValidBST(space(level.length()), root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(" ", root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(2147483647);
        boolean result = isValidBST(n);
        System.out.println(result);
    }
}