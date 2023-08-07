/*

Topic:- Check if Matrix Is X-Matrix

Link:- https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/

Problem:-

A square matrix is said to be an X-Matrix if both of the following conditions hold:

All the elements in the diagonals of the matrix are non-zero.
All other elements are 0.
Given a 2D integer array grid of size n x n representing a square matrix, return true if grid is an X-Matrix. Otherwise, return false.

Example 1:

Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
Output: true
Explanation: Refer to the diagram above. 
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is an X-Matrix.
Example 2:

Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
Output: false
Explanation: Refer to the diagram above.
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is not an X-Matrix.
 
Constraints:

n == grid.length == grid[i].length
3 <= n <= 100
0 <= grid[i][j] <= 105




Solution:-
*/
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int[][] array=grid;
         boolean bool=false;
         for(int i=0; i<grid.length; i++){
             if(!(grid[i][i]!=0)) return false;
          
             if(!(grid.length%2!=0 && ((grid.length/2))==i)) grid[i][i]=0;
         }    
         int count=0;
         for(int i=grid.length-1;i>=0; i--){
             if(!(grid[i][count]!=0)) return false;
             grid[i][count]=0;
             count++;
         }  
        for(int[] a:grid){
            for(int ele:a){
                if(ele!=0) return false;
            }
        }
        return true;
    }
}
