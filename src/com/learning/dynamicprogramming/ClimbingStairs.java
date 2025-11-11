package com.learning.dynamicprogramming;

public class ClimbingStairs {

    public int countWays(int n){
        if(n==0 || n==1){
            return 1;
        }
        return countWays(n-1)+countWays(n-2);
    }

    public int countWaysWithTabulation(int n){

        int [] dp = new int[n+1];
        // Base condition
        dp[0] = 1;
        dp[1]=1;

        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n=4;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int noWays = climbingStairs.countWays(n);
        System.out.println("Number of Ways: "+noWays);

        noWays = climbingStairs.countWaysWithTabulation(5);
        System.out.println("Number of ways with tabulation: "+ noWays);
    }
}
