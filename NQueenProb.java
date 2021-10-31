package com.company;


public class NQueenProb {

    public static void main(String[] args) {
        //no of queens
        int n = 4;
        //chess board
        int[][] arr = new int[n][n]; // nxn chess board
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = 0;
            }
        }
        nQueen(arr,0,n);

        //printing the chess board

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    // checking whether the queen position is safe or not
    public static boolean isSafe(int[][] arr,int row,int col,int n){
        // IF there is any queen in the column
        for(int i=0;i<row;i++){
            if(arr[i][col] == 1){
                return false;
            }
        }

        //If there is any queen in the diagonal

        //left diagonal
        int i = row;
        int j = col;
        while(i>=0 && j>=0){
            if(arr[i][j]==1){
                return false;
            }

                i--;
                j--;

        }
        //right diagonal
        i = row;
        j = col;
        while(i>=0 && j<n){
            if(arr[i][j]==1){
                return false;
            }

                i--;
                j++;

        }
        return true;

    }
    public static boolean nQueen(int[][] arr,int row,int n){
        //base case (if our all the queens are successfully set in each row)
        if(row>=n){
            return true;
        }
        for(int col=0;col<n;col++){
            if(isSafe(arr,row,col,n)){
                arr[row][col] = 1;

                if(nQueen(arr,row+1,n)){        // checking after putting the queen in the position can we put another queen in another row
                    return true;
                }

                arr[row][col] = 0;   // backtracking
            }
        }
        return false;
    }
}
