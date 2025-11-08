package com.learning.prefixSum;

public class ProductArray {
    /**
     *  Product of Array Except Self
     * **/

    public void method1(int[] array){
        /**
         *  Using prefix and suffix
         * **/
        int [] prefixProduct= new int[array.length];
        int [] suffixProduct = new int[array.length];
        int n = array.length;

        prefixProduct[0] = 1;
        suffixProduct[n-1] = 1;
        for(int i=1;i<n;i++){
            prefixProduct[i] = array[i-1]* prefixProduct[i-1];
        }

        System.out.println("Product of prefix elements ");
        int count=0;
        for(int v: prefixProduct){
            System.out.println("Prefix Product Index"+count+":"+v);
            count++;
        }
        int index=0;
        for (int j= n-2;j>=0;j--){
            suffixProduct[j] = array[j+1] * suffixProduct[j+1];
        }

        for(int v: suffixProduct){
            System.out.println("Index :"+index);
            System.out.println("suffix product: "+v);
            index++;
        }

        for (int i=0;i<n;i++){
            System.out.println("Product with index "+i+" is as: "+prefixProduct[i]*suffixProduct[i]);
        }
    }

    public void method2(int[] array){
        System.out.println(" ** Method2 Called with product array approach **");
        int product=1;
        int zeros = 0;

        for(int i=0;i<array.length;i++){
            if(array[i] != 0){
                product *= array[i];
            } else {
                zeros += 1;
            }
        }

        int[] productArray = new int[array.length];
        for(int i=0;i<array.length; i++){
            productArray[i] = product/array[i];
        }

        for (int i=0;i<productArray.length;i++){
            System.out.println("Product with index "+i+" is as: "+productArray[i]);
        }
    }

    public static void main(String []args){
        int[] array= new int[]{5,7,8,9,3};

        ProductArray productArray = new ProductArray();
        productArray.method1(array);
        productArray.method2(array);

    }
}
