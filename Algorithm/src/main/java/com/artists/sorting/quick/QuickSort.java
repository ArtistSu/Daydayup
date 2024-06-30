package com.artists.sorting.quick;

import com.artists.common.Xor;

/**
 * Quick Sort
 * Time Complexity: O(n)
 * Space Complexity:
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left < right){
            Xor.swap(arr,left + (int)(Math.random()*(right-left + 1)),right);
            int[] p = partition(arr,left,right);
            quickSort(arr,left,p[0]-1); // > [specific number]
            quickSort(arr,p[1]+1,right); // < [specific number]
        }
    }

    // 3 zone like [<....=...>...]
    public static int[] partition(int[] arr, int left, int right){
        int less = left - 1; // right bound of <
        int more = right; // left bound of >
        while(left < more){ // left -> current position
            if(arr[left] <arr[right]){
                Xor.swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                Xor.swap(arr,left,--more);
            }else{
                left++;
            }
        }
        Xor.swap(arr,more,right); // swap the specific number to = zone
        return new int[]{less+1,more};
    }
}
