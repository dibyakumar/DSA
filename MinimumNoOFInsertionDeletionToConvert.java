
// Find out minimum number of insertion and deletion required to convert String str1 to String str2

package com.company;

public class MinimumNoOFInsertionDeletionToConvert {
    static int[][] t;
    public static void main(String[] args) {
    String str1 = "heap";
    String str2 = "pea";
    int m = str1.length();
    int n = str2.length();

    int lcs = LCS(str1,str2,m,n);

    int deletion = m - lcs;
    int insertion = n - lcs;

        System.out.println("The Min no of deletion ="+deletion+"\n The Min no of insertion = "+insertion);
     }
     public static int LCS(String str1,String str2,int m,int n){
        t = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0&&j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
     }
}
