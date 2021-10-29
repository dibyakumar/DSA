package com.company;

public class EvaluateExpressionToTrue {
    static int[][][] t ;
    public static void main(String[] args) {
        String s = "T^F&T";
        t = new int[s.length()+1][s.length()+1][2];
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s.length()+1;j++){
                for(int k=0;k<2;k++){
                    t[i][j][k] = -1;
                }
            }
        }
        int res = boolean_parenthesization(s,0,s.length()-1,1);
        System.out.println("The number of ways to evaluate the expression to true is = "+ res);
    }
    public static int boolean_parenthesization(String s, int i, int j, int isTrue){
        if(i>j){
            return 0;
        }
        if(i == j){
            if(isTrue==1){
                return (s.charAt(i)=='T')?1:0;
            }else{
                return (s.charAt(i))=='F'?1:0;
            }
        }
        if(t[i][j][isTrue]!=-1){
            System.out.println(t[i][j][isTrue]);
            return t[i][j][isTrue];
        }
        int ans =0;
        for(int k = i+1;k<=j-1;k+=2){
            int LT=boolean_parenthesization(s, i, k-1, 1);
            int LF=boolean_parenthesization(s, i, k-1,0);
            int RT=boolean_parenthesization(s, k+1, j, 1);
            int RF=boolean_parenthesization(s, k+1, j, 0);


            if(s.charAt(k) == '&'){
                if(isTrue==1){
                    ans = ans+LT*RT;
                }else{
                    ans = ans + RT*LF + LT*RF + LF*RF;
                }
            }
            else if(s.charAt(k) == '|'){
                if(isTrue==1){
                    ans = ans+RT*LF + LF*RT + LT*RT;
                }else{
                    ans = ans + RF*LF;
                }
            }
            else if(s.charAt(k) == '^'){
                if(isTrue==1){
                    ans = ans + LT*RF + LF*RT ;
                }else{
                    ans = ans + LT*RT + LF*RF;
                }
            }
        }
        t[i][j][isTrue] = ans;
        return ans;


    }
}

