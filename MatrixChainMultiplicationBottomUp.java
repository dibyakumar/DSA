package com.company;

public class MatrixChainMultiplicationBottomUp {
    static int[][] t;
    public static void main(String[] args) {
        int[] arr = {10,30,5,60};
        t = new int[arr.length+1][arr.length+1];
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<arr.length+1;j++) {
                t[i][j] = -1;
            }
        }
        int res = mcm(arr,1,arr.length-1);
        System.out.println("The minimum number of multiplication required = "+res);
    }
public static int mcm(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int mn = Integer.MAX_VALUE;
        if(t[i][j]!=-1){
            return t[i][j];
        }
        for(int k=i;k<j;k++){
            int left,right;
            if(t[i][k]!=-1){
                left = t[i][k];
            }else{
                left = mcm(arr,i,k);
            }
            if(t[k+1][j]!=-1){
                right = t[k+1][j];
            }else{
                right = mcm(arr,k+1,j);
            }
            int temp_ans = left+right+arr[i-1]*arr[k]*arr[j];

            if(mn>temp_ans){
                mn = temp_ans;
            }
        }
        t[i][j] = mn;
        return mn;
}
}
