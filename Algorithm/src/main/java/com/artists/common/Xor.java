package com.artists.common;

/**
 * 1. N^0 = N
 * 2. a^b^c = c^b^a = c^a^b = b^a^c = b^c^a
 * 3. a^a = 0
 * 3. a^b^a = a^a^b = b
 * 4. If you want to use this way to swap, please confirm
 * a and b are 2 separate memory. Otherwise you can see
 *
 * If i,j point to same space, so
 * arr[i] = arr[j]
 * arr[i] = arr[i]^arr[i] = 0
 * arr[j] = arr[i]^arr[j] = 0
 * arr[i] = arr[i]^arr[j] = 0
 *
 * Test1: If here is an array, Only one number appears an odd
 * number of times, the rest appear an even number of times.
 * Which number is this odd number?
 *
 * Test2: If here is an array, Only two number appears an odd
 * number of times, the rest appear an even number of times.
 * Which number are these two odd number?
 */
public class Xor {

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        System.out.println("Before swap: a = " + a + ",b = "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swap: a = " + a + ",b = "+b);
        System.out.println("Please don't use this way");

        int[] arr = new int[]{a,b};
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
        System.out.println("arr[0] = " + arr[0] + ",arr[1] = " + arr[1]);

        // Even a = c are same value
        int c = a;
        int[] arr2 = new int[]{a,c};
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
        System.out.println("arr[0] = " + arr[0] + ",arr[1] = " + arr[1]);

        /**
         * Test1
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         */
        int[] testArr = new int[]{10,10,10,2,2,3,3,4,4,4,4};
        int xor_res = 0;
        for (int i = 0; i < testArr.length; i++) {
            xor_res = xor_res ^ testArr[i];
        }
        System.out.println("xor_res = " + xor_res);

        /**
         * Test2
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         */
        int[] testArr_2 = new int[]{5,5,5,6,6,6,6,6,2,2,3,4,3,4};
        int xor_res_2 = 0;
        int eor = 0;
        for (int i = 0; i < testArr_2.length; i++) {
            eor ^= testArr_2[i];
        }
        // xor_res_2 != 0 caz there are 2 kinds of number,
        // so a != b, so a^b != 0
        // eor = a^b
        // Find rightmost 1
        int rightOne = eor & (~eor + 1);
        for (int cur : testArr_2){
            if((cur & rightOne) == 1){
                xor_res_2 ^= cur;
            }
        }
        System.out.println("The numbers appear odd number times are " + xor_res_2 + "," + (eor ^ xor_res_2));

    }


}
