package com.artists.sorting.heapsort;

/**
 * Heapsort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
public class Java_912 {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums,nums.length,i);
        }

        // Totally swap last element with first element (nums.length - 1) times
        for (int i = nums.length - 1; i > 0 ; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // We reduce the heap size by 1 every iteration
            maxHeapify(nums,i,0);
        }
        return nums;
    }

    public void maxHeapify(int[] nums, int heapSize, int index) {
        int left = 2 * index  + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }

        if (right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }

        if (largest != index){
            int temp = nums[index];
            nums[index] = nums[largest];
            nums[largest] = temp;
            maxHeapify(nums, heapSize, largest);
        }
    }
}
