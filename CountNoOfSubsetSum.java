
// count number of subset sum equal to given sum problem

package com.company;

public class CountNoOfSubsetSum {
    static int[] arr;
    static int Sum;
    static int[][] t;
    static {
        arr = new int[]{1,4,8,3,7,2,5};
        Sum = 7;
        t = new int[arr.length+1][Sum+1];
    }

    public static void main(String[] args) {

        initialization();
        int res = countSubsetSum(arr,Sum,arr.length);
        System.out.println("The number of Subset sum equal to given sum is  = "+ res);
    }

    public static void initialization(){
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<Sum+1;j++){
                if(i==0)
                    t[i][j] = 0;
                if(j==0)
                    t[i][j] = 1;
            }
        }
    }
    public static int countSubsetSum(int[] arr,int sum, int n){

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];

    }
}
