package com.company;

public class MinNoOfInsertionToMakePalindrome {
    static int[][] t ;
    public static void main(String[] args) {
      String s = "aebcbda";
      int m = s.length();
      String rev_s = new StringBuilder(s).reverse().toString();
      int insertion = m - LCS(s,rev_s,m);
        System.out.println("The no of insertion to make a string palindrome is  = "+insertion);
    }
    public static int LCS(String s1,String s2,int m){
        t = new int[m+1][m+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        for (int i=1;i<m+1;i++){
            for (int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][m];
    }
}
