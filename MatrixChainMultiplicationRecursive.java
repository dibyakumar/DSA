package com.company;

public class MatrixChainMultiplicationRecursive {

    public static void main(String[] args) {
        int[] arr = {10,30,5,60};
        int res = mcm(arr,1,arr.length-1);

        System.out.println("The minimum number of multiplication required to multiply given matrix is =  "+res);
    }
    public static int mcm(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int mn = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp_ans = mcm(arr,i,k) + mcm(arr,k+1,j)+arr[i-1] * arr[k] * arr[j];

            if(mn>temp_ans){
                mn = temp_ans;
            }
        }
        return  mn;
    }
}
