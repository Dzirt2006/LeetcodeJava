package com.leetcode;

import java.util.Arrays;

public class Sortings {
    int[] slicer(int[] arr, int start, int end) {
        // Get the slice of the Array
        int[] slice = new int[end - start];
        // Copy elements of arr to slice
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
        // return the slice
        System.out.println("Slice " + Arrays.toString(slice));
        return slice;
    }

    //----------------------------------------------------------------------------------------------merge sort-------------------
    protected int[] mergeSort(int[] arr) {
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return arr;
        } else if (arr.length < 2) {
            return arr;
        } else {
            System.out.println(arr.length / 2);
            int[] leftArr = mergeSort(slicer(arr, 0, arr.length / 2));
            int[] rightArr = mergeSort(slicer(arr, arr.length / 2, arr.length));
            int left = 0;
            int right = 0;
            int newIndx = 0;
            int[] newArr = new int[arr.length];
            while (left < leftArr.length && right < rightArr.length) {
                if (leftArr[left] < rightArr[right]) {
                    newArr[newIndx] = leftArr[left];
                    left++;
                } else {
                    newArr[newIndx] = rightArr[right];
                    right++;
                }
                newIndx++;
            }
            while (left < leftArr.length) {
                newArr[newIndx] = leftArr[left];
                left++;
                newIndx++;
            }
            while (right < rightArr.length) {
                newArr[newIndx] = rightArr[right];
                right++;
                newIndx++;
            }
            return newArr;
        }
    }
}

