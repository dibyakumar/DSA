package com.company;

import java.util.ArrayList;

public class MinimumSubsetSumDiff {
    static int[] arr;
    static boolean[][] t1;
    static {
        arr = new int[]{1,6,11,5};
    }
    public static void main(String[] args) {
         int result = minimumSubsetDiff(arr);
        System.out.println("Now the MinimumSubset sum Difference = "+result);
    }
    public static void initialization1(int[] arr ,int Sum){
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<Sum+1;j++){
                if(i==0)
                    t1[i][j] = false;
                if(j==0)
                    t1[i][j] = true;
            }
        }
    }
    public static ArrayList<Integer> subsetSum(int[] arr, int sum){
        t1 = new boolean[arr.length+1][sum+1];
        initialization1(arr,sum);
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t1[i][j] = t1[i-1][j-arr[i-1]] || t1[i-1][j];
                }
                else{
                    t1[i][j] = t1[i-1][j];
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i= arr.length;
        for(int j=0;j<sum+1;j++){
            if(t1[i][j])
                res.add(j);
        }
        return res;

    }
    public static int minimumSubsetDiff(int[] arr){

        int range = 0;
        for(int i = 0;i<arr.length;i++){
            range+=arr[i];
        }
        ArrayList<Integer> filteredRange = subsetSum(arr,range);
        int res = Integer.MAX_VALUE;
        for(int i =0;i< filteredRange.size()/2;i++){
            res = Math.min(res,range-2*filteredRange.get(i));
        }

        return res;

    }
}
