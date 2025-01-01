package com.learning.question3;

import java.util.LinkedList;

public class IntegerSum {
    public static void main(String[] args) {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        System.out.println(list1);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        System.out.println(list2);
        System.out.println(generateNumber(list1));
        System.out.println(generateNumber(list2));
        System.out.println(generateNumber(list1)+generateNumber(list2));
        int sum = generateNumber(list1)+generateNumber(list2);
        LinkedList<Integer> output = convertToList(sum);
        System.out.println(output);
    }

    public static Integer generateNumber(LinkedList<Integer> list){
        double number =0;
        int size = list.size();
        int position = 0;

        for(int i=0;i<size;i++){
            number = number+ (list.get(i)*Math.pow(10,position));
            position++;
        }

        return (int)number;
    }

    public static LinkedList<Integer>convertToList(int number){
        System.out.println("Number :"+number);
        LinkedList<Integer> output = new LinkedList<Integer>();
        while(number>0){
            output.add(number%10);
             number = number/10;
        }
        System.out.println(output);
        return output;
    }

}
