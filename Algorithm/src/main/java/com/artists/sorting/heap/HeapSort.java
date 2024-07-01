package com.artists.sorting.heap;

import com.artists.common.Xor;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class HeapSort {
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        while (left < heapSize) {
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            Xor.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            Xor.swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
}
