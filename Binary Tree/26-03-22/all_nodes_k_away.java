import java.util.ArrayList;
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

    private static ArrayList<TreeNode> list;
    private static ArrayList<Integer> ans;

    public boolean find(TreeNode root, int data) {

        if (root == null)
            return false;

        if (root.val == data) {

            list.add(root);
            return true;
        }

        boolean left = find(root.left, data);
        if (left) {

            list.add(root);
            return true;
        }

        boolean right = find(root.right, data);
        if (right) {

            list.add(root);
            return true;
        }

        return false;
    }

    public void dfs(TreeNode root, TreeNode blocker, int k) {

        if (root == null || root == blocker || k < 0)
            return;

        if (k == 0)
            ans.add(root.val);

        dfs(root.left, blocker, k - 1);
        dfs(root.right, blocker, k - 1);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        list = new ArrayList<>();
        ans = new ArrayList<>();

        find(root, target.val);

        for (int i = 0; i < list.size(); i++)
            dfs(list.get(i), i == 0 ? null : list.get(i - 1), k - i);

        return ans;
    }
}