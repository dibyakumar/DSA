package com.company;

public class UnboundedKnapsackTopDown {
    int[][] t;
    public static void main(String[] args) {
    UnboundedKnapsackTopDown unboundedKnapsackTopDown = new UnboundedKnapsackTopDown();

        int[] val = new int[]{1,3,5,9};
        int[] wt = new int[]{2,3,4,1};
        int W = 7;
        unboundedKnapsackTopDown.t = new int[val.length+1][W+1];
        for(int i =0;i<val.length+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0)
                unboundedKnapsackTopDown.t[i][j] = 0;
                if (j==0)
                    unboundedKnapsackTopDown.t[i][j] = 0;
            }
        }

        int res = unboundedKnapsackTopDown.unbounded_knapsack_memoization(val,wt,W,val.length);

        System.out.println("The Max profit is  = "+res);

    }

    public int unbounded_knapsack_memoization(int[] val,int[] wt, int W, int n){

        for(int i =1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<= j){
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];

    }
}
