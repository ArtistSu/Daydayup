package com.artists.sorting.merge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question: In an array, if the number on the left is larger than the number
 * on the right, then the two numbers form a reverse pair. Please
 * print all reverse pairs.
 *
 * E.g.
 * [3,2,4,5,0]
 * Reverse pair:
 * (3,2) (3,0) (2,0) (4,0)(5,0)
 *
 * Time Complexity:
 * Space Complexity:
 */
public class ReversePair {

    public static Set<String> reversePair(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        Set<String> res = new HashSet<>();
        return process(arr,0,arr.length-1,res);
    }

    public static Set<String> process(int[] arr, int left, int right,Set<String> res){
        if(left == right){
            return null;
        }

        int mid = left + ((right - left) >> 1);
        process(arr,left,mid,res);
        process(arr,mid+1,right,res);
        return merge(arr,left,mid,right,res);
    }

    public static Set<String> merge(int[] arr, int left, int mid, int right, Set<String> res){
        int[] tmp = new int[right - left +1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;

        while(p1 <= mid &&p2 <= right){
            if(arr[p1] > arr[p2]){
                int backup = p1;
                for (int j = p1; j <= mid; j++) {
                    res.add(arr[p1++] + "," + arr[p2]);
                }
                p1= backup;
                tmp[i++] = arr[p2++];
            }else{
                tmp[i++] = arr[p1++];
            }
        }
        while(p1 <= mid){
            tmp[i++] = arr[p1++];
        }
        while(p2 <= right){
            tmp[i++] = arr[p2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[left+j] = tmp[j];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,5,0};

        for (String s : reversePair(arr)) {
            System.out.println(s);
        }


    }
}
