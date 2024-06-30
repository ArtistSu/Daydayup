package com.artists.sorting.merge;

/**
 * Question: In an array, a small sum is the sum of all figures on
 * the left-hand side of this figure. Now we want to get the sum of
 * this array's small sum.
 * E.g.
 * [1,3,4,2,5]
 * no figure smaller than 1 on the left-hand side
 * 1 smaller than 3 on its left-hand side
 * 1,3 smaller than 4 on its left-hand side
 * 1 smaller than 2 on its left-hand side
 * 1,3,4,2 smaller than 5 on its left-hand side
 *
 * So the array's small sum is 1 + (1+3) + (1) + (1+3+4+2) = 16
 */
public class SmallSum {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr, int left, int right){
        if (left == right){
            return 0;
        }
        int mid = left + ((right-left) >> 1);
        return process(arr, left, mid) +
                process(arr,mid+1,right)+
                merge(arr,left,mid,right);
    }

    public static int merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2= right;
        int smallSum = 0;
        while(p1 <= mid && p2 <= right){
            smallSum += arr[p1] < arr[p2] ? (right-p2+1)*arr[p1] : 0;
            tmp[i++] = arr[p1]<arr[p2]? arr[p1++]: arr[p2++];
        }
        while(p1 <= mid){
            tmp[i++] = arr[p1++];
        }
        while(p2 <= right){
            tmp[i++] = arr[p2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[left+j] = tmp[j];
        }
        return smallSum;
    }
}
