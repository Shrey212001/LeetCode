/*

Topic:- Determine Whether Matrix Can Be Obtained By Rotation

Link:- https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/

Problem:-

Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:

Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:

Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.



Solution:-
*/
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int row = mat.length;
       
       for(int k=0;k<=3;++k){
           int[][] r = new int[row][row];
            for(int i =0;i<row;++i){
            for(int j =0;j<row;++j){
                r[j][row-1-i]=mat[i][j];
            }
             if(Arrays.deepEquals(r,target)){
                 return true;
             }
        }
        mat = r;
       }
       return false;
        
    }
}
