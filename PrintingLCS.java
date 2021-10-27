package com.company;

public class PrintingLCS {
    static int[][] t;
    public static void main(String[] args) {
        String str1 = "aacdebe";
        String str2 = "ebedcaa";
        int m = str1.length();
        int n = str2.length();

        t = new int[m+1][n+1];

        for(int i =0;i<m+1;i++){
            for(int j =0;j<n+1;j++){
                if(i==0||j ==0){
                    t[i][j] = 0;
                }
            }
        }
        StringBuilder res = printingLcs(str1,str2,m,n);
        System.out.println("The Lcs is = "+res);

    }
    public static StringBuilder printingLcs(String str1,String str2,int m,int n){
        for(int i=1;i<m+1;i++){
            for(int j =1;j<n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder res = new StringBuilder();
        while(i>0 && j>0){

            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else{
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }

        }
        return res.reverse();
    }
}
