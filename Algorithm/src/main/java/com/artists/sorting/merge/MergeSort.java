package com.artists.sorting.merge;

/**
 * Merge Sort
 * Master Formula: T(N) = 2 * T(N/2) + O(N)
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr, int left, int right){
        if(left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr,left, mid);
        process(arr,mid+1, right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right - left +1];
        int i = 0;
        int p1 = left;
        int p2 = right + 1;
        while(p1 <= mid && p2 <= right){
            tmp[i++] = arr[p1] > arr[p2] ? arr[p2++] :arr[p1++];
        }

        while(p1 <= mid){
            tmp[i++] = arr[p1++];
        }

        while(p2 <= right){
            tmp[i++] = arr[p2++];
        }

        for (int j = 0; j < tmp.length; j++) {
            arr[left + j] = tmp[j];
        }
    }
}
