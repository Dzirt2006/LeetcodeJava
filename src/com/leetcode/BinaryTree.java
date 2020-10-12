package com.leetcode;


import java.util.*;

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
    TreeNode mainTree = new TreeNode(1, new TreeNode(2,new TreeNode(4,new TreeNode(8), new TreeNode(9)), new TreeNode(5,new TreeNode(10), null)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));


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

    //----------------------------------------------------------------branch sums-----------------------------------------------
    public static List<Integer> branchSums(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        BinaryTree.branchSumRecurcion(root,0,arr);
        return arr;
    }
    static void branchSumRecurcion(TreeNode root,int value,List<Integer> arr){
        value+=root.val;

        System.out.println();
        if(root.left==null && root.right==null){
            System.out.println(value);
            arr.add(value);
        }else {
            if (root.left != null) {
                branchSumRecurcion(root.left,value,arr);
            }
            if (root.right != null) {
                branchSumRecurcion(root.right,value,arr);
            }
        }
    }
}

class RunnerBtree{
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        System.out.println(BinaryTree.branchSums(tree.mainTree));
    }
}
