package com.learning.question4;

import java.util.Arrays;

public class TwoArraysMedian {
    public static void main(String[] args) {
        int[] array1 ={1,2};
        int[] array2 = {3,4};

       double median = findMedianSortedArrays(array1,array2);
        System.out.println("The Median value is "+ median);
    }

    public static double findMedianSortedArrays(int[] array1, int[] array2) {
        int size = array1.length + array2.length;
        int [] mergeArray = new int[size];
        int m=0;
        int n=0;
        for(int i = 0; i<size;i++){

            if(n>=array2.length){
                mergeArray[i] = array1[m];
                m++;
                continue;
            }

            if(m>=array1.length){
                mergeArray[i] = array2[n];
                n++;
                continue;
            }

            if(array1[m]<array2[n]){
                mergeArray[i]=array1[m];
                m++;
            } else{
                mergeArray[i]= array2[n];
                n++;
            }
        }
        System.out.println(Arrays.toString(mergeArray));
        int median_index = size/2;
        double median = 0;
        if(size%2 != 0){
            median = mergeArray[median_index];
        } else {
            median = (mergeArray[median_index]+mergeArray[median_index-1])/2.0;
        }
        return median;
    }
}
