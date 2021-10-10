package com.company;

public class UnboundedKnapsackMemoization {

    static int[] val;
    static  int[] wt;
    static int W;
    static int[][] t;

    static{
        val = new int[]{1,3,5,9};
        wt = new int[]{2,3,4,1};
        W = 7;
        t = new int[val.length+1][W+1];
    }

    public static void main(String[] args) {
        initialize();
        int res = unbounded_knapsack_memoization(val,wt,W,val.length);

        System.out.println("Max profit  = "+res);


    }

    private static void initialize(){

        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<W+1;j++){
                t[i][j] = -1;
            }
        }

    }

    public static int unbounded_knapsack_memoization(int[] val, int[] wt, int W, int n){

        if(W ==0 || n == 0){
            return 0;
        }
        if(t[n][W] != -1){
            return t[n][W];
        }
        if(wt[n-1]<=W){
            t[n][W] = Math.max(val[n-1]+unbounded_knapsack_memoization(val,wt,W-wt[n-1],n),
                    unbounded_knapsack_memoization(val,wt,W,n-1));

            return t[n][W];
        }
        else{

            t[n][W] = unbounded_knapsack_memoization(val,wt,W,n-1);

            return t[n][W];
        }


    }
}
