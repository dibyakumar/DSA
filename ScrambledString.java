package com.company;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
   static Map<String,Boolean> map = new HashMap<>();

   public static void main(String[] args) {
        String s1 = "coder";
        String s2 = "dreco";
        boolean res ;
        if(s1.length()!=s2.length()){
            res = false;
        } else if (s1 == "" && s2 == "") {

            res = true;
        }
        else {
            res = scrambled_string(s1, s2);
        }
       System.out.println("s2 is the scrambled string of s1 = " +res);
    }
    public static boolean scrambled_string(String s1,String s2){
        String temp=s1;
        temp+=" ";
        temp+=s2;
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        if(s1.equals(s2)){
            map.put(temp,true);
            return true;
        }
        if(s1.length()<=1){
            map.put(temp,false);
            return false;
        }


        boolean flag =false;
        for(int i=1;i<s1.length();i++){
            if(scrambled_string(s1.substring(0,i),s2.substring(s1.length()-i)) &&
            scrambled_string(s1.substring(i,s1.length()),s2.substring(0,s1.length() - i))){
                flag = true;
                break;
            }
            else if(scrambled_string(s1.substring(0,i),s2.substring(0,i)) &&
                    scrambled_string(s1.substring(i,s1.length()),s2.substring(i,s1.length()))){
                flag = true;
                break;
            }
        }
        map.put(temp,flag);
        return flag;
    }
}
