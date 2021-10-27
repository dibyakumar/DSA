package com.company;

public class PrintingShortestCommonSuperSequence {
    static int[][] t;
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";
        int m = s1.length();
        int n = s2.length();

        String shortest_common_supersequence = printing_Shortest_Common_SuperSequence(s1,s2,m,n);

        System.out.println("The Shortest common superSequence is = "+new StringBuilder(shortest_common_supersequence).reverse());

    }
    public static String printing_Shortest_Common_SuperSequence(String s1,String s2,int m,int n){
        t = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j =1;j<n+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        String res = "";
        int i = m;
        int j =n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res+= Character.toString(s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    res+=Character.toString(s1.charAt(i-1));
                    i--;
                }else{
                    res+=Character.toString(s2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            res+=Character.toString(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            res+=Character.toString(s2.charAt(j-1));
            j--;
        }
        return res;
    }
}
