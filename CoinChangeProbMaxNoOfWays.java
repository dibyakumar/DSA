
// coin change problem to find the maximum number of ways to make the given sum

package com.company;

public class CoinChangeProbMaxNoOfWays {
    int[][] t ;
    public static void main(String[] args) {
        CoinChangeProbMaxNoOfWays objCoin = new CoinChangeProbMaxNoOfWays();
        int[] coin = new int[]{2,1,3};
        int n= coin.length;
        int sum = 5;
        objCoin.t = new int[coin.length+1][sum+1];
        for(int i =0;i<coin.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    objCoin.t[i][j] = 0;
                }
                if(j==0){
                    objCoin.t[i][j] = 1;
                }
            }
        }

        int res = objCoin.coinChangeMaxNoOfWays(coin,sum,n);

        System.out.println("The number of ways to make the given sum with the the given coins are = "+res);
    }

    public int coinChangeMaxNoOfWays(int[] coin,int sum,int n){
        for(int i=1;i<n+1;i++){
            for(int j =1;j<sum+1;j++){
                if(coin[i-1]<=j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

}
