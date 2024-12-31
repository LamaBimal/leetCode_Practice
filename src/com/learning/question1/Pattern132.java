package com.learning.question1;

public class Pattern132 {

    // 132 pattern
    public static void main(String[] args) {
	    int [] numArray = {-2,3,2,-1,1,0};
	    int length = numArray.length;
        System.out.println("Array length is "+ length);

        for(int i=0;i<length-2;i++){
            for(int j=i+1; j<length-1; j++){
                for(int k = j+1; k<length; k++){
                    if(numArray[i]< numArray[k] && numArray[k]< numArray[j]){
                        System.out.println("Pattern found"+ numArray[i]+numArray[j]+numArray[k]);
                    }
                }
            }
        }
    }
}
