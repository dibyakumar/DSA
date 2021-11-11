package com.company;
public class KnightTour {
    public static void main(String[] args) {

        int n = 8;
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
        // defining the row and col value to which the knight can move
        int[] leftmove = new int[]{-2,-1,1,2,2,1,-1,-2};
        int[] righttmove = new int[]{1,2,2,1,-1,-2,-2,-1};
        knightTour(arr,0,0,n,1,leftmove,righttmove);

        //printing the chess with all moves of the knight
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    //checking the position  of the knight
    public static boolean isSafe(int[][] arr,int row,int col,int n){
        return (row>=0 && col>=0 && row<n && col < n && arr[row][col] == -1);
    }
    //solution function
    public static boolean knightTour(int[][] arr,int row,int col,int n,int move,int[] leftmove,int[] rightmove){
        if(move == n*n){
            return true;
        }
        for(int i=0;i<8;i++){
            // calculating the row and column for knight position
            int r = row+leftmove[i];
            int c = col+rightmove[i];
            if(isSafe(arr,r,c,n)){
                arr[r][c] = move;
                if(knightTour(arr,r,c,n,move+1,leftmove,rightmove)){
                    return true;
                }else{
                    arr[r][c] = -1;
                }
            }
        }
        return false;

    }
}
