package com.learning.prefixSum;

// Java program to find longest sub-array having sum k

import java.util.HashMap;

public class LongestSubArray {

    public int findLongestSubArrayWithTarget(int [] array, int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int prefixSum = 0;
        int longestSubArrayLength =0;
        for(int index=0; index<array.length;index++){

            prefixSum += array[index];

            if(prefixSum == target){
                longestSubArrayLength = index+1;
            }

            if(hashMap.containsKey(prefixSum-target)){
                longestSubArrayLength = Math.max(longestSubArrayLength,index-hashMap.get(prefixSum-target));
            }

            if(!hashMap.containsKey(prefixSum))
                hashMap.put(prefixSum,index);

            System.out.println(hashMap);
        }

        return longestSubArrayLength;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2,0,8, 10};
        int target = 8;

        LongestSubArray subArray = new LongestSubArray();
        int output = subArray.findLongestSubArrayWithTarget(array, target);
        System.out.println("Longest Sub Array Length: "+output);

    }
}
