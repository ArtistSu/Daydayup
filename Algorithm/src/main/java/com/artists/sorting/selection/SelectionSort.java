package com.artists.sorting.selection;

/**
 * Source Code of selection sort
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr.length < 2 || arr == null){
            return;
        }

        for (int i = 0; i < arr.length-1 ; i++) { // i ~ N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j++) {
                minIndex = arr[j] <arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr, int i, int minIndex){
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }
}
