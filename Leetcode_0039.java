/*
Topic:- Reshape the Matrix

Link:- https://leetcode.com/problems/reshape-the-matrix/

Problem:-

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:


Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:


Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300


Solution:-
*/
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) {
            return nums;
        }
        int col = nums[0].length;
        if (col == 0) {
            return nums;
        }
        int newSize = r * c;
        int currentSize = row * col;
        if (newSize != currentSize) {
            return nums;
        }
        int[][] result = new int[r][c];
        int k = 0;
        int l = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[k][l];
                if (l == col - 1) {
                    k++;
                }
                l = (l + 1) % col;
            }
        }
        return result;
    }
}
