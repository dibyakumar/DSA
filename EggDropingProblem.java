package com.company;

public class EggDropingProblem {
    static int[][] t;
    public static void main(String[] args) {
        int floor = 10;
        int egg = 2;
        t = new int[egg+1][floor+1];
        for(int i=0;i<egg+1;i++){
            for(int j=0;j<floor+1;j++){
             t[i][j] = -1;
            }
        }
        int res = egg_droping(egg,floor);
        System.out.println("The min attempts = "+res);
    }
    public static int egg_droping(int egg,int floor){
        if(egg==1){
            return floor;
        }
        if(floor==0||floor==1){
            return floor;
        }
        if(t[egg][floor]!=-1){
            return t[egg][floor];
        }
        int mn = Integer.MAX_VALUE;
        for(int i=1;i<=floor;i++){
            int temp_ans = 1 + Math.max(egg_droping(egg-1,i-1),egg_droping(egg,floor-i));
            if(mn>temp_ans){
                mn = temp_ans;
            }
        }
        t[egg][floor]= mn;
        return mn;
    }
}
