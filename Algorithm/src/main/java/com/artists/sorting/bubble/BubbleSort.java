package com.artists.sorting.bubble;

/**
 * Source code of bubble sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {
    public static void BubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length-1; i > 0 ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j+1] > arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int fristEle, int secondEle){
        int tmp = arr[secondEle];
        arr[fristEle] = arr[secondEle];
        arr[secondEle] = tmp;
    }
}
