package com.leetcode;


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

public class BinaryTree {
    //new tree [3,9,20,null,null,15,7]
    TreeNode mainTree = new TreeNode(3, new TreeNode(9), new TreeNode(2, new TreeNode(15), new TreeNode(7)));


    //-----------------------------------------------------------------Maximum Depth of Binary Tree-------------easy-------------------------------------------------------------

    protected int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int result = 1;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return left >= right ? result + left : result + right;
        }
    }


}
