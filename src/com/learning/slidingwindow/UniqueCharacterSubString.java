package com.learning.slidingwindow;
/**

    A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.
For example, with this input:

s = "xyzzaz"

The substrings with length of 3 are:

s1 = "xyz" #index 0-2
s2 = "yzz" #index 1-3
s3 = "zza" #index 2-4
s4 = "zaz" #index 3-5

 ***/

public class UniqueCharacterSubString {

    public int countGoodSubstrings(String inputString){
        int leftPointer = 0;
        int rightPointer = 2;

        int unique_substring_count = 0;

        while(rightPointer <inputString.length()){
            char firstCharacter = inputString.charAt(leftPointer);
            char secondCharacter = inputString.charAt(leftPointer+1);
            char thirdCharacter = inputString.charAt(rightPointer);

            if(firstCharacter != secondCharacter && firstCharacter != thirdCharacter && secondCharacter != thirdCharacter){
                unique_substring_count++;
            }
            rightPointer++;
            leftPointer++;

        }
        return unique_substring_count;
    }

    public static void main(String[] args) {
        UniqueCharacterSubString characterSubString = new UniqueCharacterSubString();
        int unique_count = characterSubString.countGoodSubstrings("xyzazaz");
        System.out.println(unique_count);
    }
}
