
// coin change problem (Min number of coins required for the given sum)

package com.company;

public class CoinChangeProbMinNoOfCoins {

    int[][] t;

    public static void main(String[] args) {
        CoinChangeProbMinNoOfCoins objCoin = new CoinChangeProbMinNoOfCoins();
        int[] coin = new int[]{2,1,3};
        int n= coin.length;
        int sum = 5;
        objCoin.t = new int[coin.length+1][sum+1];
        for(int i =0;i<coin.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    objCoin.t[i][j] = Integer.MAX_VALUE-1;
                }
                if(j==0){
                    objCoin.t[i][j] = 0;
                }
            }
        }
        int i =0;
            for(int j=1;j<sum+1;j++){
            if(j%coin[i]==0){
                objCoin.t[i][j] =j/coin[i];
            }else
                objCoin.t[i][j] = Integer.MAX_VALUE-1;
            }

            int res = objCoin.coinChangeProbMinCoins(coin,sum,n);

        System.out.println("The number of coins to make the given sum with the the given coins are = "+res);
    }

    public int coinChangeProbMinCoins(int[] coin,int sum,int n){

           for(int i=1;i<coin.length+1;i++){
               for(int j =1;j<sum+1;j++){

                   if(coin[i-1]<=j){
                       t[i][j] = Math.min(1+t[i][j-coin[i-1]],t[i-1][j]);
                   }else{
                       t[i][j] = t[i-1][j];
                   }
               }
           }

           return t[n][sum];

    }
}
