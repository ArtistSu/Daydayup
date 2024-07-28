package com.artists.sorting.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java_1200 {
    /**
     * Time Complexity:O(n)
     * Space Complexity:O(max(arr)+abs(min(arr)))
     * Counting Sort
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Get maximum and minimum
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            max = num > max ? num : max;
            min = num < min ? num : min;
        }

        // Define new array for count sort
        int shift = Math.abs(min);
        int[] arr_2 = new int[shift+max+1];

        // Counting
        for(int i = 0;i<arr.length; i++){
            arr_2[arr[i]+shift] += 1;
        }

        // Sort
        int p = 0;
        int compar_1 = Integer.MIN_VALUE;
        int compar_2 = Integer.MIN_VALUE;
        boolean rota = true;
        int min_gap = Integer.MAX_VALUE;
        for(int i = 0; i <arr_2.length;i++){
            if(arr_2[i] > 0){
                arr[p++] = i-shift;
                if(rota){
                    compar_1 = i;
                    rota = false;
                }else{
                    compar_2 = i;
                    rota = true;
                }

                if(compar_1 != Integer.MIN_VALUE && compar_2 !=Integer.MIN_VALUE){
                    min_gap = Math.min(min_gap, Math.abs(compar_2 - compar_1));
                }
            }
        }

        // Answer
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i < arr.length; i++){
            if(min_gap == Math.abs(arr[i]-arr[i-1])){
                ans.add(new ArrayList(Arrays.asList(arr[i-1],arr[i])));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,1,3};
        new Java_1200().minimumAbsDifference(test);
    }
}
