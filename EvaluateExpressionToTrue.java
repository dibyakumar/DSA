package com.company;

public class EvaluateExpressionToTrue {
    static int[][] t ;
    public static void main(String[] args) {
        String s = "T^F&T";
        int res = boolean_parenthesization(s,0,s.length()-1,true);
        System.out.println("The number of ways to evaluate the expression to true is = "+ res);
    }
    public static int boolean_parenthesization(String s, int i, int j, boolean isTrue){
        if(i>j){
            return 0;
        }
        if(i == j){
            if(isTrue){
                return (s.charAt(i)=='T')?1:0;
            }else{
                return (s.charAt(i))=='F'?1:0;
            }
        }
        int ans =0;
        for(int k = i+1;k<=j-1;k+=2){
            int LT=boolean_parenthesization(s, i, k-1, true);
            int LF=boolean_parenthesization(s, i, k-1, false);
            int RT=boolean_parenthesization(s, k+1, j, true);
            int RF=boolean_parenthesization(s, k+1, j, false);


            if(s.charAt(k) == '&'){
                if(isTrue){
                    ans = ans+LT*RT;
                }else{
                    ans = ans + RT*LF + LT*RF + LF*RF;
                }
            }
            else if(s.charAt(k) == '|'){
                if(isTrue){
                    ans = ans+RT*LF + LF*RT + LT*RT;
                }else{
                    ans = ans + RF*LF;
                }
            }
            else if(s.charAt(k) == '^'){
                if(isTrue){
                    ans = ans + LT*RF + LF*RT ;
                }else{
                    ans = ans + LT*RT + LF*RF;
                }
            }
        }
        return ans;


    }
}

