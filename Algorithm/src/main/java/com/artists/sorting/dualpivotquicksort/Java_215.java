package com.artists.sorting.dualpivotquicksort;

import java.util.Arrays;

public class Java_215 {
    /**
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
