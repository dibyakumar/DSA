package com.company;

public class EqualSubsetSum {
    static int[] arr;
    static boolean[][] t;
    static {
        arr = new int[]{4,5,3,2,4};
    }
    public static void main(String[] args) {
      if(equalSubsetSum(arr)){
          System.out.println("Two Equal Subset sum is present . ");
      }else{
          System.out.println("No Equal subset Sum is present");
      }
    }
    public static void initialization(int[] arr ,int Sum){
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<Sum+1;j++){
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }
    }
    public static boolean subsetSum(int[] arr,int sum){
        t = new boolean[arr.length+1][sum+1];
        initialization(arr,sum);
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
    public static boolean equalSubsetSum(int[] arr){
        int TotalSum =0;
        for(int i=0;i<arr.length;i++){
            TotalSum+=arr[i];
        }
        if(TotalSum %2 != 0){
            return false;
        }
        else {
            return subsetSum(arr,TotalSum/2);
        }
    }
}
