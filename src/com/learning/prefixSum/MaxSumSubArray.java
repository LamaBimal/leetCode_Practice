package com.learning.prefixSum;

import java.util.HashMap;

/***
 * Given an integer array arr[], find the subarray (containing at least one element) which has the maximum possible sum, and return that sum.
 * Note: A subarray is a continuous part of an array.
 *
 * Examples:
 *
 * Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
 * Output: 11
 * Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
 *
 * Input: arr[] = [-2, -4]
 * Output: -2
 * Explanation: The subarray [-2] has the largest sum -2.
 *
 * Input: arr[] = [5, 4, 1, 7, 8]
 * Output: 25
 * Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
 *
 */
public class MaxSumSubArray {
    public int calculateMaxSumArray(int [] array){

        int maxSum = array[0];

        int maxEnding = array[0];

        for(int i=1;i<array.length; i++){
            maxEnding = Math.max(maxEnding+array[i],array[i]);
            maxSum = Math.max(maxSum,maxEnding);
        }
        return maxSum;
    }
    public static void main(String[] args) {

        int[] source = new int[]{5,-3,7,-8,15};
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        int maxSum = maxSumSubArray.calculateMaxSumArray(source);
        System.out.println("Maximum Sum of subset is "+maxSum);

    }
}
