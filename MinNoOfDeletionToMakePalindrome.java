package com.company;

public class MinNoOfDeletionToMakePalindrome {
    static int[][] t;
    public static void main(String[] args) {
    StringBuilder str =new StringBuilder("agbcba");
    int m = str.length();
        int no_of_deletion = m - LCS(str.toString(), str.reverse().toString(),m);
        System.out.println("The no of deletion in to make a the string palindrome is  =  "+no_of_deletion);
    }
    public static int LCS(String str1,String str2,int m){
        t = new int[m+1][m+1];

        for(int i =0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    t[i][j] =0;
                }
            }
        }
        for(int i=1;i<m+1;i++) {
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][m];
    }
}
