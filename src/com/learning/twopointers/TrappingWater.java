package com.learning.twopointers;

public class TrappingWater {

    public int calculateWaterAmount(int [] elevation){

        int length = elevation.length;
        int start = 0;
        int end = length-1;

        int trappingAmount = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (start < end){

            if(elevation[start] <= elevation[end]){
                maxLeft = Math.max(maxLeft, elevation[start]);
                trappingAmount = trappingAmount+ maxLeft-elevation[start];
                start++;
            } else {
                maxRight = Math.max(maxRight, elevation[end]);
                trappingAmount += maxRight - elevation[end];
                end--;
            }

        }
        return trappingAmount;
    }

    public static void main(String[] args) {
        TrappingWater trappingWater = new TrappingWater();
        int[] blocks = new int[] {3,5,7,0,4};
        int trappedWater = trappingWater.calculateWaterAmount(blocks);
        System.out.println("Trapping water is "+trappedWater);
    }
}
