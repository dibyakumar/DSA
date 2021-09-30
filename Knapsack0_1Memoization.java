// 0_1 knapsack problem

package com.company;

public class Knapsack0_1Memoization {
    static int[] val;
    static int[] wt;
    static int W;
    static int[][] t;
    static {
        val = new int[]{1,4,5,7};
        wt = new int[]{1,3,4,5};
        W = 7;
        t = new int[val.length+1][W+1];
    }
    public static void main(String[] args) {
        initialization();
        int res = knapsack(val,wt,W,val.length);
        System.out.println("The Max profit will be = "+ res);
    }
    public static void initialization(){
        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<W+1;j++){

                    t[i][j] = -1;
            }
        }
    }

    public static int knapsack(int[] val,int[] wt, int W, int n){

        if(n==0 || W==0){
            return 0;
        }
         if(t[n][W]!=-1){
             return t[n][W];
         }
        if(wt[n-1]<=W){
            t[n][W] = Math.max(val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),knapsack(val,wt,W,n-1));
            return t[n][W];
        }
        else if(wt[n-1]>W){
            t[n][W]=knapsack(val,wt,W,n-1);
            return t[n][W];
        }
        else{
            return -1;
        }

    }
}
