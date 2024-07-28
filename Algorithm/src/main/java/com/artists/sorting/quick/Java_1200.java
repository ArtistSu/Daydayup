package com.artists.sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java_1200 {
    /**
     * Time Complexity:O(nlogn)
     * Space Complexity: O(logn)
     * Quick Sort
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        // Find the mininum absolute difference
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int gap = arr[i] - arr[i - 1];
            if (gap < min) {
                ans.clear();
                min = gap;
            }

            if (gap == min) {
                ans.add(new ArrayList(Arrays.asList(arr[i - 1], arr[i])));
            }
        }
        return ans;
    }
}
