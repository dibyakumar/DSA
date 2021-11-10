package com.company;

public class SudokuSolver {
    public static void main(String[] args) {
int n =9;
int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
//calling the function
sudokuSolver(arr,n);

// printing the solved sudoku
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static boolean isSafe(int[][] arr,int row,int col,int n,int val){
        //checking in the row if the value is present or not
        for(int i=col;i<n;i++){
            if(val == arr[row][i]){
                return false;
            }
        }
        //checking in the col if the value is present or not
        for(int i=row;i<n;i++){
            if(val == arr[i][col]){
                return false;
            }
        }
        //checking in the 3x3 matrix the value is present or not

        int sqr = (int) Math.sqrt(n);
        int rowstart = row - (row%sqr);
        int colstart = col - (col%sqr);
        for(int i=rowstart;i<rowstart+sqr;i++){
            for(int j=colstart;j<colstart+sqr;j++){
                if(val == arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int[][] arr,int n){

        //checking which position is free
        int row =-1;
        int col = -1;
        boolean flag = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0){
                    row = i;
                    col = j;
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        // baseCase
        if(flag){
            return true;
        }

        for(int i=1;i<=9;i++){
            // checking can we put the current digit in that position
            if(isSafe(arr,row,col,n,i)){
                arr[row][col] = i;
                // check for other positions
                if(sudokuSolver(arr,n)){
                    return true;
                }else{
                    //if the solution is not coming then backtrack
                    arr[row][col] = 0;//backtracking
                }
            }
        }


           return false;
        }

}
