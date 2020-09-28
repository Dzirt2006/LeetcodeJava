package com.leetcode;

import java.util.Arrays;

public class MainLeetCode {
    public static void main(String[] args) {
        Problems instance = new Problems();
//        System.out.println(instance.singleNumber(new int[]{4,1,2,1,2}));
//        instance.twoSumBrute(new int[]{2, 7, 11, 15},26);
//        System.out.println(instance.getRandomHexString(6));
//        System.out.println(instance.isPalindrome(9));
//        instance.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
//        System.out.println(instance.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
//        System.out.println(instance.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        int[]arr=instance.mergeSort(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(Arrays.toString(instance.mergeSort(new int[]{4,-1,3,6, 7, 0, 1,5, 2})));
//        for(int i: arr){
//            System.out.println(arr[i]);
//        }
        //trees
        BinaryTree tree = new BinaryTree();
//        System.out.println(tree.maxDepth(tree.mainTree));


    }
}
