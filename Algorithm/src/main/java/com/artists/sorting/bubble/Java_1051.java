package com.artists.sorting.bubble;

/**
 * Bubble Sort
 * @author ArtistS
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Tip: clone() is shallow copy
 */
public class Java_1051 {
    public int heightChecker(int[] heights) {
        int[] heights_bkp = heights.clone();
        int res = 0;

        for (int i = 1; i < heights.length; i++) {
            for (int j = 0; j < heights.length - i; j++) {
                if(heights[j] > heights[j+1]){
                    int tmp = heights[j+1];
                    heights[j+1]=heights[j];
                    heights[j] = tmp;
                }
            }
        }

        for (int i = 0; i < heights.length; i++) {
            if(heights_bkp[i] != heights[i]){
                res++;
            }
        }
        return res;
    }
}
