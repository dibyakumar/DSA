// here we have to find whether String A is  a subsequence of B or not
package com.company;

public class SequencePatternMatching {
    static int[][] t;
    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";
        int m = a.length();
        int n = b.length();
        boolean res = m == LCS(a,b,m,n);

        System.out.println("A is subsequence of b : "+res);

    }
    public static int LCS(String s1 , String s2,int m,int n){
         t  = new int[m+1][n+1];
         for(int i=0;i<m+1;i++){
             for(int j=0;j<n+1;j++ ){
                 if(i==0||j==0){
                     t[i][j] = 0;
                 }
             }
         }
         for(int i=1;i<m+1;i++){
             for(int j=1;j<n+1;j++){
                 if(s1.charAt(i-1)==s2.charAt(j-1)){
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
