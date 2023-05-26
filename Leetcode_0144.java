/*

Topic:- Special Positions in a Binary Matrix

Link:- https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

Problem:-

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

Example 1:

Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:

Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions. 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.




Solution:-
*/

class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int res = 0;
        if(n == 1 && n == 1) return mat[0][0];
        int flag = 0;
        int col = -1;
        for(int i=0; i<n; i++){
            flag = 0;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    flag += 1;
                    col = j;
                } 
            }
                if(flag == 1){
                    flag = 0;
                    for(int row = 0; row<n; row++){
                        if(mat[row][col] == 1){
                            flag += 1;
                        }
                    }
                }
            if(flag == 1){
                res += 1; 
            }
        }
        return res;
    }
}
