package com.learning.twopointers;

/**
 *  Given a sorted array, find if there exists a pair of elements whose sum equals a target value.
 * */

public class SumTwoNumber {

    public boolean findTarget(int[] sortedArray, int target){

        int length = sortedArray.length;
        int leftPointer = 0;
        int rightPointer = length-1;

        while(leftPointer < rightPointer){
            int sum = sortedArray[leftPointer]+sortedArray[rightPointer];
            if(sum== target)
                return true;

            if(sum < target){
                leftPointer ++;
            } else {
                rightPointer--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [] array = new int[] {3,5,7,8,10};
        SumTwoNumber sumTwoNumber = new SumTwoNumber();
        int target = 18;
        boolean targetExists = sumTwoNumber.findTarget(array, target);
        if(targetExists)
            System.out.println("Target "+target+" sum has found ..");
        else
            System.out.println("Target "+ target+ "sum has not found ..");
    }
}
