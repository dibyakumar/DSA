package com.company;

public class ShortestCommonSuperSequence {
    static int[][] t;
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "eke";
        int m = str1.length();
        int n = str2.length();

        int scs = m+n-LCS(str1,str2,m,n);

        System.out.println("The length of the shortest common super sequence is = "+scs);

    }
    public static int LCS(String str1,String str2,int m,int n){
        t = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++ ){
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i=1;i<m+1;i++ ){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
