package com.company;

public class RatInMaze {
    public static void main(String[] args) {

        int n =4;
        int[][] matrix ={{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        int[][] soln = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                soln[i][j] =0;
            }
        }
        maze(matrix,0,0,n,soln);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(soln[i][j]+" ");
            }
            System.out.println();
        }


    }
    // checking is the position for the mouse is right or wrong
    public static boolean isSafe(int[][] arr , int row,int col,int n){
        return row < n && col < n && arr[row][col] == 1;
    }
    // finding the path
    public static boolean maze(int[][] arr,int row,int col,int n,int[][] soln){
        if(row==n-1 && col==n-1){
            soln[row][col] = 1;
            return true;
        }
//checking is the position of the rat is safe or not
        if(isSafe(arr,row,col,n)){
            soln[row][col] = 1;
    //checking can we go forward
            if(maze(arr,row+1,col,n,soln)){
                return true;
            }
            //can we go down word
            if(maze(arr,row,col+1,n,soln)){
                return true;
            }
            //if we cant go forward and down word then make that position 0 and come back (Backtracking)
            soln[row][col] = 0;
            return false;
        }
return false;
    }
}
