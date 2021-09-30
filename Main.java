 // 0_1 knapsack problem

 package com.company;
public class Main {

    public static void main(String[] args) {
        int[] val = {1,4,5,7};
        int[] wt = {1,3,4,5};
        int W = 7;
       int res = knapsack(val,wt,W,val.length);
        System.out.println("The Max profit will be = "+ res);
    }

    public static int knapsack(int[] val,int[] wt, int W, int n){

     if(n==0 || W==0){
         return 0;
     }

     if(wt[n-1]<=W){
         return Math.max(val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),knapsack(val,wt,W,n-1));
     }
     else if(wt[n-1]>W){
         return knapsack(val,wt,W,n-1);
     }
     else{
         return -1;
     }

    }
}
