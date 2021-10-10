package com.company;

public class RodCuttingProb {
    int[][] t ;
    public static void main(String[] args) {
        RodCuttingProb rodCuttingProb = new RodCuttingProb();
        int[] length = new int[]{1,2,3,4,5,6,7,8};
        int[] price = new int[]{1,5,8,9,10,17,17,20};

        //length of the rod given
        int N = 8;

        rodCuttingProb.t = new int[length.length+1][N+1];

        for(int i=0;i<length.length+1;i++){
            for (int j=0;j<N+1;j++){
                if(i == 0)
                rodCuttingProb.t[i][j] = 0;
                if(j == 0)
                    rodCuttingProb.t[i][j] = 0;
            }
        }
        int res = rodCuttingProb.rodCutting_Prob(length,price,N,length.length);

        System.out.println("Now the Max profit after cutting the will be =  "+ res);
    }
    public int rodCutting_Prob(int[] length,int[] price,int N,int n){
        for(int i=1;i<n+1;i++){
            for(int j =0  ; j <N+1;j++){
                if(length[i-1]<=j){
                    t[i][j] =Math.max(price[i-1]+t[i][j-length[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][N];
    }

}
