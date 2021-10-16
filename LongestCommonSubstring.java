package com.company;

public class LongestCommonSubstring {
    static int[][] t ;
    public static void main(String[] args) {
        String str1 = "abdef";
        String str2 = "abcfg";

        int  m = str1.length();
        int n = str2.length();
       t = new int[m+1][n+1];
        for(int i =0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
     int longestSubstring = longestCommonSubstring(str1,str2,m,n);

        System.out.println("The longest common substring = "+longestSubstring);
    }
    public static int longestCommonSubstring(String str1,String str2,int m,int n){
        // to track the max substring length
        int max =0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = 0;
                }
                if(max<t[i][j]){
                    max = t[i][j];
                }
            }
        }
        return max;

    }
}
