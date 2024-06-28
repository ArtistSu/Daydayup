package com.artists.common;

import com.artists.sorting.insertion.InsertionSort;

import java.util.Arrays;

public class Comparator {

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            // e.g. I want to test insertionSort
            InsertionSort.insertionSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Brilliant" : "Damn failed");
    }

    /**
     * Math.random() -> [0,1) decimal with equal probability
     * Math.random() * N -> [0,N) decimal with equal probability
     * (int)(Math.random()*N) -> [0,N-1] integer with equal probability
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize+1)* Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue+1)*Math.random());
        }
        return arr;
    }


    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if((arr1==null && arr2 != null) || (arr1!= null && arr2==null)){
            return false;
        }
        if(arr1==null && arr2==null){
            return true;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
