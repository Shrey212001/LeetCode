/*

Topic:- Lucky Numbers in a Matrix

Link:- https://leetcode.com/problems/lucky-numbers-in-a-matrix/

Problem:-

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.




Solution:-
*/
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> ls = new ArrayList<Integer>();

         for (int i=0; i<n; i++){
             int num = Integer.MAX_VALUE;
             int index = -1;
            for (int j=0; j<m; j++){
                if(matrix[i][j] < num){
                    num = matrix[i][j];
                    index = j;
                }
            }
             boolean flag = true;
             for(int row=0; row<n; row++){
                 if(matrix[row][index] > num ) flag = false;
             }
             if(flag) ls.add(num);
        }

        return ls;
    }
}
