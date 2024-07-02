package com.artists.sorting.quick;

public class Java_912 {
    /**
     * Quick Sort
     * Time Complexity: O(nlogn)
     * Space Complexity: O(logn)
     */
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            swap(nums,left+(int)(Math.random()*(right-left+1)),right);
            int[] p = partition(nums,left,right);
            quickSort(nums,left,p[0]-1); // > zone
            quickSort(nums,p[1]+1,right); // < zone
        }
    }

    public int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, left, --more);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
