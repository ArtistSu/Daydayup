package com.artists.sorting.counting;

/**
 * Counting sort
 * Time Complexity: O(N+K) N: the length of nums K: the max values of nums
 * Space Complexity: O(K)
 */
public class Java_75 {
    public void sortColors(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int maxNum = 1;
        for (int num: nums){
            maxNum = num > maxNum ? num:maxNum;
        }

        int[] bkp = new int[maxNum+1];
        for(int i = 0; i < nums.length; i++){
            bkp[nums[i]]++;
        }

        int pointer = 0;
        for(int i = 0; i < bkp.length;i++){
            int count = bkp[i];
            while(count > 0){
                nums[pointer++] = i;
                count--;
            }
        }
    }
}
