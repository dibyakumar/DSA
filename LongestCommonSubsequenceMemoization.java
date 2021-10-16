package com.company;

public class LongestCommonSubsequenceMemoization {
   static int[][]  t;
    public static void main(String[] args) {
        String str1 = "abdef";
        String str2 = "abcfg";
        int m = str1.length();
        int n = str2.length();

        //table
        t = new int[m+1][n+1];
        for(int i =0;i<m+1;i++){
            for(int j =0;j<n+1;j++){
                t[i][j] = -1;
            }
        }

        int lcs = lcsMemoization(str1,str2,m,n);
        System.out.println("The Longest common subsequence is = "+lcs);

    }
    public static int lcsMemoization(String str1 , String str2,int m,int n){

        if(m == 0 || n == 0){
            return 0;
        }

        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(str1.charAt(m-1)== str2.charAt(n-1)){
            t[m][n] = 1+lcsMemoization(str1,str2,m-1,n-1);

            return t[m][n];
        }
        else{
            t[m][n] = Math.max(lcsMemoization(str1,str2,m-1,n),lcsMemoization(str1,str2,m,n-1));
            return t[m][n];
        }

    }
}
