package com.company;

public class UnboundedKnapsackRecursive {

    public static void main(String[] args) {

        int[] val = new int[]{1,3,5,9};
        int[] wt = new int[]{2,3,4,1};

        int W = 7;

        int res = unbounded_knapsack_recursive(val,wt,W,val.length);

        System.out.println("Max profit  = "+res);

    }

    public static int unbounded_knapsack_recursive(int[] val,int [] wt, int W, int n){

        if(n == 0 || W == 0 ){
             return  0;
        }

        if(wt[n-1]<=W){
            return Math.max(val[n-1]+unbounded_knapsack_recursive(val,wt,W-wt[n-1],n),
                    unbounded_knapsack_recursive(val,wt,W,n-1)
            );
        }
            else {
                return unbounded_knapsack_recursive(val,wt,W,n-1);
            }
        }

    }


