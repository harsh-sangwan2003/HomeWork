
//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private static int tilt;

    public int findTilt(TreeNode root) {

        tilt = 0;

        sum(root);

        return tilt;
    }

    public int sum(TreeNode root) {

        if (root == null)
            return 0;

        int lsum = sum(root.left);
        int rsum = sum(root.right);

        tilt += Math.abs(lsum - rsum);

        return root.val + lsum + rsum;
    }
}