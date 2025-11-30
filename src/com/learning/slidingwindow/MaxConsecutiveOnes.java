package com.learning.slidingwindow;

/***
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 */

public class MaxConsecutiveOnes {

    public int findLongestOnes(int [] numbers, int maxZeros){
        int left =0;
        int right =0;
        int zerosCount = 0;
        int maxOnes = 0;

        for(int i=0;i< numbers.length; i++){

            if(numbers[i]==0) zerosCount++;

            while(zerosCount> maxZeros){
                if(numbers[left]==0)
                    zerosCount--;
                left++;
            }
            maxOnes = Math.max(maxOnes, right-left+1);
            right++;

        }

        return maxOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int [] input = new int[]{1,0,1,0,1,0,1,0,1,1};
        int maxValue = maxConsecutiveOnes.findLongestOnes(input,3);
        System.out.println("Maximum Ones length is "+maxValue);
    }
}
