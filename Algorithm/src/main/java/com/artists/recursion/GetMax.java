package com.artists.recursion;

public class GetMax {

    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[]arr, int left, int right){
        if(left == right){
            return arr[left];
        }

        // Don't use (left+right)/2 -> this may spill
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr,0,mid);
        int rightMax = process(arr,mid+1, right);
        return Math.max(leftMax, rightMax);
    }
}
