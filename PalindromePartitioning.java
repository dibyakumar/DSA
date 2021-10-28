package com.company;

public class PalindromePartitioning {
    static int[][] t;
    public static void main(String[] args) {
    String s = "dibya";
    t = new int[s.length()+1][s.length()+1];
    for(int i =0;i<s.length()+1;i++) {
        for(int j=0;j<s.length()+1;j++){
            t[i][j] = -1;
        }
        }
int res = palindrome_partitioning(s,0,s.length()-1);
        System.out.println("The minimum number of partition required  = "+ res);
    }
    public static boolean isPalindrome(String s){
        String rev_s = new StringBuilder(s).reverse().toString();
        if(rev_s.equals(s)){
            return true;
        }else{
            return false;
        }
    }
    public static int palindrome_partitioning(String s,int i,int j){
        if(i>=j || isPalindrome(s)){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        int mn = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int left,right;
            if(t[i][k]!=-1){
                left = t[i][k];
            }else{
                left = palindrome_partitioning(s,i,k);
            }
            if(t[k+1][j]!=-1){
                right = t[k+1][j];
            }else{
                right = palindrome_partitioning(s,k+1,j);
            }
            int temp_ans = 1+left+right;
            if(mn>temp_ans){
                mn = temp_ans;
            }
        }
        t[i][j] = mn;
        return mn;
    }

}
