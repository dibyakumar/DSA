package com.company;

public class SubsetSum {
    static int[] arr;
    static int Sum;
    static boolean[][] t;
    static {
        arr = new int[]{1,4,8,3};
        Sum = 7;
        t = new boolean[arr.length+1][Sum+1];
    }

    public static void main(String[] args) {
        initialization();
       if(subsetSum(arr,Sum,arr.length)){
           System.out.println("Yes there exists a subset whose sum is equal to the given sum . ");
       }else {
           System.out.println("No there is no such subset present whose sum equal to the given sum . ");
       }
    }

    public static void initialization(){
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<Sum+1;j++){
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }
    }
    public static boolean subsetSum(int[] arr,int sum,int n){


        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if (arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else if (arr[i-1]>sum){
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];


    }
}
