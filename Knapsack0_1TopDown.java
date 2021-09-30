package com.company;

class Knapsack0_1Topdown{
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
        int res = KnapsackTopDown(val,wt,W,val.length);
        System.out.println("Max profit = "+res);
    }
    public static void initialization(){
        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0)
                    t[i][j] = 0;
            }
        }
    }
    public static int KnapsackTopDown(int[] val, int[] wt , int W,int n){
        for(int i=1;i<val.length+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }
                else if(wt[i-1]>W){
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][W];


    }
}
