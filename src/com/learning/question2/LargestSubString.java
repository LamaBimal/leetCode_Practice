package com.learning.question2;

import java.util.HashSet;
import java.util.Set;

public class LargestSubString {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> window = new HashSet<Character>();

        int left = 0, right = 0;
        while(right < s.length()) {
            System.out.println(" Right value :"+right);

            while(window.contains(s.charAt(right))){
                System.out.println("Window contains "+s.charAt(right));
                System.out.println("left value: "+left);
                window.remove(s.charAt(left++));
                System.out.println("After remove: "+window);
                System.out.println("after remove left value: "+left);
            }
            System.out.println("Before "+window);
            window.add(s.charAt(right++));
            System.out.println(window);
            maxLen = Math.max(maxLen, right - left);
        }
        System.out.println(window);
        return maxLen;
    }

    public static void main(String[] args) {
        LargestSubString largestSubString = new LargestSubString();
        int length = largestSubString.lengthOfLongestSubstring("abcdecbb");
        System.out.println(length);
    }

}
