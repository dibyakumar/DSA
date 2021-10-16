package com.company;

public class LongestCommonSubsequenceRecursive {

    public static void main(String[] args) {
	 String str1 = "abdef";
	 String str2 = "abcfg";
	 int m = str1.length();
	 int n = str2.length();

	 int lcs = lcsRecursive(str1,str2,m,n);

        System.out.println("The longest common subsequence is = "+ lcs);

    }
    public static int lcsRecursive(String str1,String str2,int m,int n){

        // BaseCase

        if (m == 0 || n == 0){
            return 0;
        }

        if(str1.charAt(m-1)==str2.charAt(n-1)){

            return 1+lcsRecursive(str1,str2,m-1,n-1);
        }

        else{
            return Math.max(lcsRecursive(str1,str2,m-1,n),lcsRecursive(str1,str2,m,n-1));
        }

    }
}
