package code.course;

@SuppressWarnings("unused")
class TreeNode {
    int val = -1;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                '}';
    }
}

@SuppressWarnings("unused")
class SolutionIsBST {

    public static String getLevel(String s) {
        s = s + s + s;
        return s;
    }

    public static String space(int i) {
        String s = "  ";
        for (int k = 0; k < i; k++) {
            s = s + " ";
        }
        return s;
    }

    public static boolean isValidBST(String level, TreeNode root, long min, long max) {
        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + " >> isValidBST(" + root + ", " + min + ", " + max + ")");

        if (root == null) { return true; }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(space(level.length()), root.left, min, root.val) &&
                isValidBST(space(level.length()), root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST("    ", root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3, n2, n3);

        /*
                    3(n1)
           2(n2)             5(n3)
      1(n4)      4(n5)   null     null

         */

        boolean result = isValidBST(n1);
        System.out.println(result);
    }
}