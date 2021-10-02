package com.company;

public class TargetSum {
    static int[] num;
    static int target;
    static int[][] t;
    static{
        num = new int[]{1,1,2,3};
        target = 1;
    }
    public static void main(String[] args) {
        int res = targetSum(num,target);
        System.out.println("Now the total no of expression equal to given target  = "+ res);
    }
    public static void initialization(int[] arr,int sum){
        for (int i=0;i<arr.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }
    }

    public static int countNoOfSubsetSum(int[] arr,int sum){
        t =  new int[arr.length+1][sum+1];
        initialization(arr,sum);

        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }

    public static int targetSum(int[] arr,int target){

        int sum_arr = 0;

        for(int i=0;i<arr.length;i++){
            sum_arr+=arr[i];
        }

        int subset1 = (sum_arr+target)/2;

        return countNoOfSubsetSum(arr,subset1);

    }

}
